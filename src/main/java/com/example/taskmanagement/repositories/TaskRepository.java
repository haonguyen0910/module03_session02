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
}
