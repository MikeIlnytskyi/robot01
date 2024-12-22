package com.example.robots0_1.enti;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("movement_history") // Назва таблиці у Cassandra
@Getter
@Setter
public class MovementHistory {

    @PrimaryKey // Поле використовується як первинний ключ
    private UUID movementId;

    @Column("robot_id") // Зв'язок із роботом
    private UUID robotId;

    @Column("timestamp") // Час події
    private String timestamp;

    @Column("location") // Локація
    private String location;

    @Column("action") // Дія
    private String action;

    // Конструктор за замовчуванням
    public MovementHistory() {
        this.movementId = UUID.randomUUID(); // Генеруємо унікальний ID
    }

    // Конструктор для створення історії з параметрами
    public MovementHistory(UUID robotId, String timestamp, String location, String action) {
        this.movementId = UUID.randomUUID(); // Генеруємо унікальний ID
        this.robotId = robotId;
        this.timestamp = timestamp;
        this.location = location;
        this.action = action;
    }
}
