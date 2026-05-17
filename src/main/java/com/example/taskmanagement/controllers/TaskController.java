package com.example.taskmanagement.controllers;

import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.models.User;
import com.example.taskmanagement.services.TaskService;
import com.example.taskmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;
    private UserService userService;

    @Autowired
    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAllTasks(@RequestParam(required = false) String search) {
        List<Task> tasks = taskService.findAllTasks();

        if(search != null && !search.isEmpty()) {
            List<Task> result = new ArrayList<>();

            for (Task x : tasks) {
                if (x.getTitle().toLowerCase().contains(search.toLowerCase())) {
                    result.add(x);
                }
            }
            tasks = result;
        }
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<?> addTask(@RequestBody Task newTask) {
        User user = userService.findUserById(newTask.getAssignedTo());

        if (user == null){
            return ResponseEntity.badRequest().body("Không tìm thấy User");
        }

        boolean isExists = taskService.isTaskExists(newTask.getId());

        if(isExists) {
            return ResponseEntity.status(409).body("Id nhiệm vụ bị trùng");
        }

        Task task = taskService.addTask(newTask);
        return ResponseEntity.status(201).body(task);
    }
}
