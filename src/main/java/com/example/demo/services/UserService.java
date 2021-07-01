package com.example.demo.services;

import com.example.demo.controllers.requests.CreateUserRequest;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserRequest createUserRequest) {
        return userRepository.create(createUserRequest);
    }

    public User findUserById(Integer userId) {
        return userRepository.findById(userId);
    }
}
