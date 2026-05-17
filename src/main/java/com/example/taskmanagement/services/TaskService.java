package com.example.taskmanagement.services;

import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.models.User;
import com.example.taskmanagement.repositories.TaskRepository;
import com.example.taskmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task){
        User user = userRepository.findUserById(task.getAssignedTo());
        if (user == null) {
            return null;
        }
        return taskRepository.addTask(task);
    }

    public boolean isTaskExists(Long id) {
        Task task = taskRepository.findTaskById(id);
        return task != null;
    }

    public Task updateTask(Long id, Task task) {
        return taskRepository.save(id, task);
    }

    public Task deleteTaskById(Long id) {
        return taskRepository.deleteById(id);
    }
}
