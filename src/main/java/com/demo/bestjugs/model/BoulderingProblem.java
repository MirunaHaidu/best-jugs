package com.demo.bestjugs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
@Entity(name = "boulderingProblems")
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
