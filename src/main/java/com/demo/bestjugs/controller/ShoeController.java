package com.demo.bestjugs.controller;

import com.demo.bestjugs.dto.ShoeDto;
import com.demo.bestjugs.dto.UserDto;
import com.demo.bestjugs.model.Shoe;
import com.demo.bestjugs.model.User;
import com.demo.bestjugs.service.ShoeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
@ControllerAdvice
public class ShoeController {
    private final ShoeService shoeService;


    public ShoeController(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    @PostMapping("/createShoe")
    public ResponseEntity<Shoe> createShoe(@Valid @RequestBody ShoeDto shoeDto){
        Shoe shoe = shoeService.addShoe(shoeDto);
        return new ResponseEntity<>(shoe, HttpStatus.CREATED);
    }
}
