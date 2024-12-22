package com.example.robots0_1.Controller;

import com.example.robots0_1.enti.TaskQueue;
import com.example.robots0_1.Service.TaskQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/taskQueue")
public class TaskQueueController {

    private final TaskQueueService taskQueueService;

    @Autowired
    public TaskQueueController(TaskQueueService taskQueueService) {
        this.taskQueueService = taskQueueService;
    }

    // Отримати всі завдання
    @GetMapping
    public List<TaskQueue> getAllTasks() {
        return taskQueueService.getAllTasks();
    }

    // Отримати завдання за ID
    @GetMapping("/{id}")
    public TaskQueue getTaskById(@PathVariable UUID id) {
        return taskQueueService.getTaskById(id);
    }

    // Створити нове завдання
    @PostMapping
    public TaskQueue createTask(@RequestBody TaskQueue taskQueue) {
        return taskQueueService.saveTask(taskQueue);
    }

    // Оновити існуюче завдання
    @PutMapping("/{id}")
    public TaskQueue updateTask(@PathVariable UUID id, @RequestBody TaskQueue updatedTask) {
        return taskQueueService.updateTask(id, updatedTask);
    }

    // Видалити завдання
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable UUID id) {
        taskQueueService.deleteTask(id);
    }
}

