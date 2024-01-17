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
    @Column
    private User user;
    @OneToMany(mappedBy = "boulderingProblem", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<BoulderingProblem> boulderingProblems = new ArrayList<>();

    // add list of shoes -> one session, many shoes

}
