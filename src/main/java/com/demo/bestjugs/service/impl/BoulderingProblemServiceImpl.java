package com.demo.bestjugs.service.impl;

import com.demo.bestjugs.dto.BoulderingProblemDto;
import com.demo.bestjugs.model.BoulderingProblem;
import com.demo.bestjugs.repository.BoulderingProblemRepository;
import com.demo.bestjugs.service.BoulderingProblemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("test_qualifier_boulderingServiceImpl")
@Transactional
public class BoulderingProblemServiceImpl implements BoulderingProblemService {

    private final BoulderingProblemRepository boulderingProblemRepository;
    private final ModelMapper modelMapper;

    public BoulderingProblemServiceImpl(BoulderingProblemRepository boulderingProblemRepository, ModelMapper modelMapper) {
        this.boulderingProblemRepository = boulderingProblemRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public BoulderingProblem addProblem(BoulderingProblemDto boulderingProblemDto) {
        BoulderingProblem boulderingProblem = modelMapper.map(boulderingProblemDto, BoulderingProblem.class);
        return boulderingProblemRepository.save(boulderingProblem);
    }
}
