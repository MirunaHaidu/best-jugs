package com.demo.bestjugs.service.impl;

import com.demo.bestjugs.dto.BoulderingProblemDto;
import com.demo.bestjugs.exception.ResourceNotFoundException;
import com.demo.bestjugs.model.BoulderingProblem;
import com.demo.bestjugs.model.Gym;
import com.demo.bestjugs.repository.BoulderingProblemRepository;
import com.demo.bestjugs.repository.GymRepository;
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
    private final GymRepository gymRepository;

    public BoulderingProblemServiceImpl(BoulderingProblemRepository boulderingProblemRepository, ModelMapper modelMapper, GymRepository gymRepository) {
        this.boulderingProblemRepository = boulderingProblemRepository;
        this.modelMapper = modelMapper;
        this.gymRepository = gymRepository;
    }


    @Override
    public BoulderingProblem addProblem(BoulderingProblemDto boulderingProblemDto) {
        BoulderingProblem boulderingProblem = modelMapper.map(boulderingProblemDto, BoulderingProblem.class);
        Gym gym = gymRepository.findById(boulderingProblem.getGym().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Gym", "gymId", boulderingProblem.getGym().getId()));
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
