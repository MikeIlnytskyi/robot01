package com.example.robots0_1.enti;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table("diagnostics")
@Getter
@Setter
public class Diagnostics {

    @Id
    private UUID diagnosticId; // Унікальний ідентифікатор діагностики

    private UUID robotId; // ID робота, для якого проведена діагностика
    private LocalDateTime diagnosticTime; // Час проведення діагностики
    private String status; // Результат діагностики (наприклад, "OK", "Error")
    private String details; // Деталі діагностичного звіту

    public Diagnostics() {
        this.diagnosticId = UUID.randomUUID(); // Генерація унікального ID
    }

    public Diagnostics(UUID robotId, LocalDateTime diagnosticTime, String status, String details) {
        this.diagnosticId = UUID.randomUUID(); // Генерація унікального ID
        this.robotId = robotId;
        this.diagnosticTime = diagnosticTime;
        this.status = status;
        this.details = details;
    }
}
