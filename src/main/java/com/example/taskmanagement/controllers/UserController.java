package com.example.taskmanagement.controllers;

import com.example.taskmanagement.models.User;
import com.example.taskmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(@RequestParam(required = false) String search) {
        List<User> users = userService.findAllUsers();

        if(search != null && !search.isEmpty()) {
            List<User> result = new ArrayList<>();

            for (User x : users) {
                if(x.getName().toLowerCase().contains(search.toLowerCase())) {
                    result.add(x);
                }
            }
            users = result;
        }
        return ResponseEntity.ok(users);
    }
}
