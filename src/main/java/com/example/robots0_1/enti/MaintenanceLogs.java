package com.example.robots0_1.enti;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("maintenance_logs")
@Getter
@Setter
public class MaintenanceLogs {

    @Id
    private UUID logId; // Унікальний ідентифікатор запису

    private UUID robotId; // ID робота, до якого відноситься лог
    private LocalDateTime timestamp; // Час проведення обслуговування
    private String description; // Опис обслуговування
    private String status; // Статус обслуговування (наприклад, "Completed", "Pending")

    public MaintenanceLogs() {
        this.logId = UUID.randomUUID(); // Генерація унікального ID
    }

    public MaintenanceLogs(UUID robotId, LocalDateTime timestamp, String description, String status) {
        this.logId = UUID.randomUUID(); // Генерація унікального ID
        this.robotId = robotId;
        this.timestamp = timestamp;
        this.description = description;
        this.status = status;
    }
}
