package com.example.taskmanagement.services;

import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.models.User;
import com.example.taskmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public boolean isUserExists(Long id) {
        User user = userRepository.findUserById(id);
        return user != null;
    }

    public User addUser(User user){
        User x = userRepository.findUserById(user.getId());
        if (x == null) {
            return null;
        }
        return userRepository.addUser(user);
    }

    public User updateUser(Long id, User user) {
        return userRepository.save(id, user);
    }

    public User deleteUserById(Long id) {
        return userRepository.deleteById(id);
    }

}
