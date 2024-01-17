package com.demo.bestjugs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
}
