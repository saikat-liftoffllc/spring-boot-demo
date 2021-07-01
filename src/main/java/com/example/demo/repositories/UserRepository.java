package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {
    @Override
    public User findById(Integer userId) {
        return null;
    }
}
