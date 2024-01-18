package com.demo.bestjugs.service.impl;

import com.demo.bestjugs.dto.MembershipDto;
import com.demo.bestjugs.exception.ResourceNotFoundException;
import com.demo.bestjugs.model.Gym;
import com.demo.bestjugs.model.Membership;
import com.demo.bestjugs.model.User;
import com.demo.bestjugs.repository.GymRepository;
import com.demo.bestjugs.repository.MembershipRepository;
import com.demo.bestjugs.repository.UserRepository;
import com.demo.bestjugs.service.MembershipService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("test_qualifier_membershipServiceImpl")
@Transactional
public class MembershipServiceImpl implements MembershipService {

    private final MembershipRepository membershipRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final GymRepository gymRepository;

    public MembershipServiceImpl(MembershipRepository membershipRepository, ModelMapper modelMapper, UserRepository userRepository, GymRepository gymRepository) {
        this.membershipRepository = membershipRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.gymRepository = gymRepository;
    }

    @Override
    public Membership createMembership(MembershipDto membershipDto) {
        Membership membership = modelMapper.map(membershipDto, Membership.class);
        User user = userRepository.findById(membershipDto.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", membershipDto.getUser().getId()));

        Gym gym = gymRepository.findById(membershipDto.getGym().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Gym", "gymId", membershipDto.getGym().getId()));

        membership.setUser(user);
        membership.setGym(gym);

        return membershipRepository.save(membership);
    }
}
