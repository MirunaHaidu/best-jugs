package com.demo.bestjugs.dto;

import com.demo.bestjugs.model.BoulderingSession;
import com.demo.bestjugs.model.Gym;
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
public class BoulderingProblemDto {
    private Long id;
    private String color;
    private String grade;
    private String holds;
    private LocalDate dateAdded;
    private Gym gym;
}
