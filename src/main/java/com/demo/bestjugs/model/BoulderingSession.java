package com.demo.bestjugs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "bouldering_sessions")
public class BoulderingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name = "bouldering_session_bouldering_problem", joinColumns = @JoinColumn(name = "bouldering_session_id"), inverseJoinColumns = @JoinColumn(name = "bouldering_problem_id"))
    private List<BoulderingProblem> boulderingProblems = new ArrayList<>();

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name = "bouldering_session_shoes", joinColumns = @JoinColumn(name = "bouldering_session_id"), inverseJoinColumns = @JoinColumn(name = "shoe_id"))
    private List<Shoe> shoes = new ArrayList<>();

}
