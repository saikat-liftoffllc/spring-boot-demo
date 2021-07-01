package com.example.demo.repositories;

import com.example.demo.controllers.requests.CreateUserRequest;
import com.example.demo.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public class JOOQUserRepository implements UserRepository {
    @Override
    public User create(CreateUserRequest createUserRequest) {
        System.out.println("JOOQUserRepository::create()");
        return null;
    }

    @Override
    public User findById(Integer userId) {
        System.out.println("JOOQUserRepository::findById()");
        return null;
    }
}
