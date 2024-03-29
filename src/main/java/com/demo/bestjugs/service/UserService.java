package com.demo.bestjugs.service;

import com.demo.bestjugs.dto.UserDto;
import com.demo.bestjugs.model.Shoe;
import com.demo.bestjugs.model.User;

import java.util.List;

public interface UserService {

    User createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    User findByUsername(String username);
    User findByEmail(String email);
    List<Shoe> getShoes(Long userId);
    Boolean hasMembership(Long userId, Long gymId);

}
