package com.demo.bestjugs.service.impl;

import com.demo.bestjugs.config.UserInfoConfig;
import com.demo.bestjugs.exception.ResourceNotFoundException;
import com.demo.bestjugs.model.User;
import com.demo.bestjugs.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.map(UserInfoConfig::new).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
    }
}
