package com.demo.bestjugs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

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
    @ManyToMany(mappedBy = "boulderingProblems")
    @JsonIgnore
    private List<BoulderingSession> boulderingSessions;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "gyms_id")
    private Gym gym;

}
