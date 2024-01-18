package com.demo.bestjugs.dto;

import com.demo.bestjugs.model.BoulderingProblem;
import com.demo.bestjugs.model.Shoe;
import com.demo.bestjugs.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoulderingSessionDto {
    private Long id;
    private LocalDate date;
    private User user;
    private List<BoulderingProblem> boulderingProblems;
    private List<Shoe> shoes;
}
