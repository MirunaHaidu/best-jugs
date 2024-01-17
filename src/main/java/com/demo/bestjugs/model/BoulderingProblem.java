package com.demo.bestjugs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "bouldering_problems")
public class BoulderingProblem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String color;
    @Column
    private String grade;
    @Column
    private String holds;
    @Column
    private LocalDate dateAdded;
    @ManyToOne
    @JoinColumn(name = "boulderingSession_id")
    private BoulderingSession boulderingSession;
}
