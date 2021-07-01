package com.example.demo.services;

import com.example.demo.controllers.requests.CreateUserRequest;
import com.example.demo.entities.ImmutableUser;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public void UserService() {
    }

    public User createUser(CreateUserRequest createUserRequest) {
        return ImmutableUser
                .builder()
                .id(1)
                .name("Saikat")
                .email("saikat@liftoffllc.com")
                .build();
    }
}
