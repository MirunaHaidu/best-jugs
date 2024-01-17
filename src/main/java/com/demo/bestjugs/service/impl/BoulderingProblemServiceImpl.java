package com.demo.bestjugs.service.impl;

import com.demo.bestjugs.dto.BoulderingProblemDto;
import com.demo.bestjugs.model.BoulderingProblem;
import com.demo.bestjugs.repository.BoulderingProblemRepository;
import com.demo.bestjugs.service.BoulderingProblemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("test_qualifier_boulderingProblemServiceImpl")
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

    @Override
    public List<BoulderingProblem> findByGrade(String grade) {
        List<BoulderingProblem> boulderingProblems = boulderingProblemRepository.findAll();

        return boulderingProblems.stream()
                .filter(boulderingProblem -> boulderingProblem.getGrade().contains(grade))
                .map(boulderingProblem -> modelMapper.map(boulderingProblem, BoulderingProblem.class))
                .collect(Collectors.toList());
    }
}
