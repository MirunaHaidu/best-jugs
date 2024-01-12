package com.demo.bestjugs.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 5, max = 20, message = "Username must be between 5 and 30 characters long")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "Email cannot be empty")
    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String password;


}
