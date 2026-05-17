package com.example.taskmanagement.controllers;

import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.models.User;
import com.example.taskmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        User x = userService.findUserById(id);
        if (x == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User không tìm thấy");
        }

        return ResponseEntity.status(HttpStatus.OK).body(x);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {

        boolean isExists = userService.isUserExists(user.getId());

        if(isExists) {
            return ResponseEntity.status(409).body("User Id bị trùng");
        }

        User x = userService.addUser(user);
        return ResponseEntity.status(201).body(x);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody User user) {
        User x =userService.updateUser(id, user);
        if (x == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User không tìm thấy");
        }

        return ResponseEntity.status(HttpStatus.OK).body(x);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        User x = userService.deleteUserById(id);

        if (x == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User không tìm thấy");
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
