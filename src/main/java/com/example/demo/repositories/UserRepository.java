package com.example.demo.repositories;

import com.example.demo.controllers.requests.CreateUserRequest;
import com.example.demo.entities.User;

public interface UserRepository {
    public User create(CreateUserRequest createUserRequest);
    public User findById(Integer userId);
}
