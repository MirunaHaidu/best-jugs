package com.demo.bestjugs.service.impl;

import com.demo.bestjugs.dto.UserDto;
import com.demo.bestjugs.exception.ResourceNotFoundException;
import com.demo.bestjugs.model.Shoe;
import com.demo.bestjugs.model.User;
import com.demo.bestjugs.repository.ShoeRepository;
import com.demo.bestjugs.repository.UserRepository;
import com.demo.bestjugs.service.UserService;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service("test_qualifier_userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ShoeRepository shoeRepository;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ShoeRepository shoeRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.shoeRepository = shoeRepository;
    }


    @Override
    public User createUser(UserDto userDto) {
       User user = modelMapper.map(userDto, User.class);
       return userRepository.save(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
    }

    @Override
    public List<Shoe> getShoes(Long userId) {
        return userRepository.findById(userId).get().getShoes();
    }

    @Override
    public Boolean hasMembership(Long userId, Long gymId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));


        return null;
    }
}
