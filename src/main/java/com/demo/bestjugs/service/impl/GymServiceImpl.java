package com.demo.bestjugs.service.impl;

import com.demo.bestjugs.dto.GymDto;
import com.demo.bestjugs.model.Gym;
import com.demo.bestjugs.repository.GymRepository;
import com.demo.bestjugs.service.GymService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("test_qualifier_gymServiceImpl")
@Transactional
public class GymServiceImpl implements GymService {

    private final GymRepository gymRepository;
    private final ModelMapper modelMapper;

    public GymServiceImpl(GymRepository gymRepository, ModelMapper modelMapper) {
        this.gymRepository = gymRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Gym createGym(GymDto gymDto) {
        Gym gym = modelMapper.map(gymDto, Gym.class);
        return gymRepository.save(gym);
    }
}
