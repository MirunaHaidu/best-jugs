package com.demo.bestjugs.controller;


import com.demo.bestjugs.dto.UserDto;
import com.demo.bestjugs.model.Shoe;
import com.demo.bestjugs.model.User;
import com.demo.bestjugs.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
@ControllerAdvice
public class UserController {

    private final UserService userService;


    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;

    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserDto userDto){
        User user = userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/getShoes")
    public ResponseEntity<List<Shoe>> getShoes(@RequestParam Long userId){
        List<Shoe> shoes = userService.getShoes(userId);
        return new ResponseEntity<>(shoes, HttpStatus.OK);
    }
}
