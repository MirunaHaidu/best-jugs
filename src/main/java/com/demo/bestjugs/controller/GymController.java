package com.demo.bestjugs.controller;

import com.demo.bestjugs.dto.GymDto;
import com.demo.bestjugs.dto.UserDto;
import com.demo.bestjugs.model.Gym;
import com.demo.bestjugs.model.User;
import com.demo.bestjugs.service.GymService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
@ControllerAdvice
public class GymController {
    private final GymService gymService;

    public GymController(GymService gymService) {
        this.gymService = gymService;
    }

    @PostMapping("/createGym")
    public ResponseEntity<Gym> createGym(@Valid @RequestBody GymDto gymDto){
        Gym gym = gymService.createGym(gymDto);
        return new ResponseEntity<>(gym, HttpStatus.CREATED);
    }


}
