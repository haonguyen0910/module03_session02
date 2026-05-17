package com.example.taskmanagement.controllers;

import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<Task> findAllTasks() {
        return taskService.findAllTasks();
    }
}
