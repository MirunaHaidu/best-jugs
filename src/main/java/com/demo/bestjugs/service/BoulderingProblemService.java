package com.demo.bestjugs.service;

import com.demo.bestjugs.dto.BoulderingProblemDto;
import com.demo.bestjugs.model.BoulderingProblem;
import com.demo.bestjugs.repository.BoulderingProblemRepository;

import java.util.List;

public interface BoulderingProblemService {
    BoulderingProblem addProblem(BoulderingProblemDto boulderingProblemDto);
    List<BoulderingProblem> findByGrade(String grade);
}
