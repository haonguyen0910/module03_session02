package com.example.taskmanagement.repositories;

import com.example.taskmanagement.models.User;
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

    public User findUserById(Long id) {
        for (User x : users) {
            if(x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }

    public User save(Long id, User user) {
        User x = findUserById(id);

        if (x == null) {
            return null;
        }

        x.setName(user.getName());
        x.setEmail(user.getEmail());
        x.setRole(user.getRole());

        return x;
    }

    public User deleteById(Long id) {
        User x = findUserById(id);
        if (x == null) {
            return null;
        }
        users.remove(x);

        return x;
    }
}
