package com.demo.bestjugs.dto;

import com.demo.bestjugs.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShoeDto {
    private Long id;
    private String brand;
    private String model;
    private String size;
    private LocalDate purchaseDate;
    private User owner;
}
