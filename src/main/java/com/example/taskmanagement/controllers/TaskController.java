package com.example.taskmanagement.controllers;

import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
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
}
