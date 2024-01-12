package com.demo.bestjugs.service;

import com.demo.bestjugs.dto.UserDto;
import com.demo.bestjugs.model.User;

import java.util.List;

public interface UserService {

    User createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    User findByUsername(String username);
    User findByEmail(String email);

}
