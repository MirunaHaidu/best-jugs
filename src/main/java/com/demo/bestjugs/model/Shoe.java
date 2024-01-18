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
@Entity(name = "shoes")
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private String size;
    @Column
    private LocalDate purchaseDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
    @ManyToMany(mappedBy = "shoes")
    @JsonIgnore
    private List<BoulderingSession> boulderingSessions;
}
