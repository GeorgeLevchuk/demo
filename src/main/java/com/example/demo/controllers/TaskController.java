package com.example.demo.controllers;

import com.example.demo.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final List<Task> tasks = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    // Создание задачи
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        task.setId(idCounter.getAndIncrement());
        tasks.add(task);
        return task;
    }

    // Получение списка всех задач
    @GetMapping
    public List<Task> getAllTasks() {
        return tasks;
    }

    // Получение задачи по ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Задача не найдена"));
    }

    // Обновление задачи
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        Task task = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Задача не найдена"));

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());

        return task;
    }

    // Удаление задачи
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        tasks.removeIf(task -> task.getId() == id);
        return "Задача с ID " + id + " удалена";
    }
}