package com.example.demo.services;

import com.example.demo.controllers.requests.CreateUserRequest;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserRequest createUserRequest) {
        return null;
    }

    public User findUserById(Integer userId) {
        return userRepository.findById(userId);
    }
}
