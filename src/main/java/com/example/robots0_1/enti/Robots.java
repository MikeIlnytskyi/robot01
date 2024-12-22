package com.example.robots0_1.enti;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;


@Table("robots")
@Getter
@Setter
public class Robots {

    @PrimaryKey // Поле використовується як первинний ключ
    private UUID robotId;

    @Column("model") // Відповідає колонці "model" у таблиці
    private String model;

    @Column("serial_number") // Відповідає колонці "serial_number"
    private String serialNumber;

    @Column("battery_level") // Відповідає колонці "battery_level"
    private int batteryLevel;

    @Column("current_state") // Відповідає колонці "current_state"
    private String currentState;

    // Конструктор за замовчуванням
    public Robots() {
        // Генеруємо унікальний UUID, якщо поле не встановлено вручну
        this.robotId = UUID.randomUUID();
    }

    // Конструктор для створення робота з параметрами
    public Robots(String model, String serialNumber, int batteryLevel, String currentState) {
        this.robotId = UUID.randomUUID();
        this.model = model;
        this.serialNumber = serialNumber;
        this.batteryLevel = batteryLevel;
        this.currentState = currentState;
    }

}
