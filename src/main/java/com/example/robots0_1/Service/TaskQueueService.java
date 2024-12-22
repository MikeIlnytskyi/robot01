package com.example.robots0_1.Service;

import com.example.robots0_1.enti.TaskQueue;
import com.example.robots0_1.Repository.TaskQueueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskQueueService {

    private final TaskQueueRepository taskQueueRepository;

    @Autowired
    public TaskQueueService(TaskQueueRepository taskQueueRepository) {
        this.taskQueueRepository = taskQueueRepository;
    }

    // Отримати всі завдання
    public List<TaskQueue> getAllTasks() {
        return taskQueueRepository.findAll();
    }

    // Отримати завдання за ID
    public TaskQueue getTaskById(UUID id) {
        return taskQueueRepository.findById(id).orElse(null);
    }

    // Зберегти нове завдання
    public TaskQueue saveTask(TaskQueue taskQueue) {
        return taskQueueRepository.save(taskQueue);
    }

    // Оновити існуюче завдання
    public TaskQueue updateTask(UUID id, TaskQueue updatedTask) {
        TaskQueue existingTask = taskQueueRepository.findById(id).orElse(null);
        if (existingTask == null) {
            throw new IllegalArgumentException("Task with ID " + id + " not found.");
        }
        existingTask.setRobotId(updatedTask.getRobotId());
        existingTask.setTaskDescription(updatedTask.getTaskDescription());
        existingTask.setScheduledTime(updatedTask.getScheduledTime());
        existingTask.setStatus(updatedTask.getStatus());
        return taskQueueRepository.save(existingTask);
    }

    // Видалити завдання
    public void deleteTask(UUID id) {
        taskQueueRepository.deleteById(id);
    }
}
