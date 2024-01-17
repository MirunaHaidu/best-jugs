package com.demo.bestjugs.service.impl;

import com.demo.bestjugs.dto.BoulderingSessionDto;
import com.demo.bestjugs.exception.ResourceNotFoundException;
import com.demo.bestjugs.model.BoulderingSession;
import com.demo.bestjugs.model.User;
import com.demo.bestjugs.repository.BoulderingSessionRepository;
import com.demo.bestjugs.repository.UserRepository;
import com.demo.bestjugs.service.BoulderingSessionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("test_qualifier_boulderingSessionServiceImpl")
@Transactional
public class BoulderingSessionServiceImpl implements BoulderingSessionService {

    private final BoulderingSessionRepository boulderingSessionRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public BoulderingSessionServiceImpl(BoulderingSessionRepository boulderingSessionRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.boulderingSessionRepository = boulderingSessionRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }


    @Override
    public BoulderingSession createSession(BoulderingSessionDto boulderingSessionDto) {
        BoulderingSession boulderingSession = modelMapper.map(boulderingSessionDto, BoulderingSession.class);
        User user = userRepository.findById(boulderingSessionDto.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", boulderingSessionDto.getUser().getId()));
        boulderingSession.setUser(user);


        return boulderingSessionRepository.save(boulderingSession);
    }
}
