package com.example.taskmanagement.repositories;

import com.example.taskmanagement.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public UserRepository() {
        users.add(new User(1L, "admin", "admin@gmail.com", "ADMIN"));
        users.add(new User(2L, "nguyenvanan", "nguyenvanan@gmail.com", "USER"));
        users.add(new User(3L, "tranvanbinh", "tranvanbinh@gmail.com", "USER"));
    }

    public List<User> findAll() {
        return users;
    }
}
