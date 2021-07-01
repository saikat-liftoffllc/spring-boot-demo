package com.example.demo.repositories;

import com.example.demo.entities.User;

public interface IUserRepository {
    public User findById(Integer userId);
}
