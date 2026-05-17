package com.example.taskmanagement.repositories;

import com.example.taskmanagement.models.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {

    List<Task> tasks = new ArrayList<>();

    public TaskRepository() {
        tasks.add(new Task(1L, "Viết báo cáo", "Báo cáo tuần", "HIGH", 1L));
        tasks.add(new Task(2L, "Họp dự án", "Họp với team", "MEDIUM", 2L));
        tasks.add(new Task(3L, "Fix bug", "Sửa lỗi login", "HIGH", 1L));
        tasks.add(new Task(4L, "Viết tài liệu", "API documentation", "LOW", 3L));
        tasks.add(new Task(5L, "Test hệ thống", "Unit test", "MEDIUM", 2L));
        tasks.add(new Task(6L, "Deploy", "Lên môi trường prod", "HIGH", 1L));
        tasks.add(new Task(7L, "Họp khách hàng", "Demo sản phẩm", "HIGH", 3L));
        tasks.add(new Task(8L, "Optimize DB", "Tối ưu query", "MEDIUM", 2L));
        tasks.add(new Task(9L, "Viết README", "Hướng dẫn cài đặt", "LOW", 1L));
        tasks.add(new Task(10L, "Backup dữ liệu", "Backup hàng tuần", "LOW", 3L));
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task findTaskById(Long id) {
        for (Task x : tasks) {
            if(x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public Task save(Long id, Task task) {
        Task x = findTaskById(id);

        if (x == null) {
            return null;
        }

        x.setTitle(task.getTitle());
        x.setDescription(task.getDescription());
        x.setPriority(task.getPriority());
        x.setAssignedTo(task.getAssignedTo());

        return x;
    }

    public Task deleteById(Long id) {

        Task x = findTaskById(id);
        if (x == null) {
            return null;
        }
        tasks.remove(x);

        return x;
    }
}
