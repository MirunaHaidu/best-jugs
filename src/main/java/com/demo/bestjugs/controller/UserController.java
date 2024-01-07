package com.demo.bestjugs.controller;

import com.demo.bestjugs.dto.UserDto;
import com.demo.bestjugs.exception.UserNotFoundException;
import com.demo.bestjugs.model.User;
import com.demo.bestjugs.security.JWTUtil;
import com.demo.bestjugs.service.UserService;
import jakarta.validation.Valid;
import org.hibernate.boot.model.internal.CollectionSecondPass;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
@ControllerAdvice
public class UserController {
    private final UserService userService;
    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, JWTUtil jwtUtil, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerHandler(@Valid @RequestBody UserDto userDto) throws UserNotFoundException{
        String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(encodedPassword);

        User user = userService.addUser(userDto);
        String token = jwtUtil.generateToken(user.getEmail());

        return new ResponseEntity<>(Collections.singletonMap("jwt-token", token),
                HttpStatus.CREATED);
    }





}
