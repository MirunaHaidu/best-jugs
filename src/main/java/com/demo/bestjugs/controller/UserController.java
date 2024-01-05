package com.demo.bestjugs.controller;

import com.demo.bestjugs.dto.UserDto;
import com.demo.bestjugs.model.User;
import com.demo.bestjugs.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
@ControllerAdvice
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid UserDto userDto){
        return ResponseEntity.ok(userService.addUser(userDto));
    }

}
