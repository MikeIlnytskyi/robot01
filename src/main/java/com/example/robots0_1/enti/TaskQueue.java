package com.example.robots0_1.enti;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("task_queue")
@Getter
@Setter
public class TaskQueue {

    @Id
    private UUID taskId; // Унікальний ідентифікатор завдання

    private UUID robotId; // ID робота, для якого призначене завдання
    private String taskDescription; // Опис завдання
    private LocalDateTime scheduledTime; // Запланований час виконання
    private String status; // Статус завдання (наприклад, "Pending", "In Progress", "Completed")

    public TaskQueue() {
        this.taskId = UUID.randomUUID(); // Генерація унікального ID
    }

    public TaskQueue(UUID robotId, String taskDescription, LocalDateTime scheduledTime, String status) {
        this.taskId = UUID.randomUUID(); // Генерація унікального ID
        this.robotId = robotId;
        this.taskDescription = taskDescription;
        this.scheduledTime = scheduledTime;
        this.status = status;
    }
}
