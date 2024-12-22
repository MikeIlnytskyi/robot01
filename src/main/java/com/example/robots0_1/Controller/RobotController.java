package com.example.robots0_1.Controller;

import com.example.robots0_1.enti.Robots;
import com.example.robots0_1.Service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/robots")
public class RobotController {

    private final RobotService robotService;

    @Autowired
    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    // Отримати список усіх роботів
    @GetMapping
    public List<Robots> getAllRobots() {
        return robotService.getAllRobots();
    }

    // Отримати робота за ID
    @GetMapping("/{id}")
    public Robots getRobotById(@PathVariable UUID id) {
        return robotService.getRobotById(id);
    }

    // Створити нового робота
    @PostMapping
    public Robots createRobot(@RequestBody Robots robot) {
        return robotService.saveRobot(robot);
    }

    // Оновити дані робота
    @PutMapping("/{id}")
    public Robots updateRobot(@PathVariable UUID id, @RequestBody Robots updatedRobot) {
        Robots existingRobot = robotService.getRobotById(id);
        if (existingRobot == null) {
            throw new IllegalArgumentException("Robot with ID " + id + " not found.");
        }
        // Оновлення даних
        existingRobot.setModel(updatedRobot.getModel());
        existingRobot.setSerialNumber(updatedRobot.getSerialNumber());
        existingRobot.setBatteryLevel(updatedRobot.getBatteryLevel());
        existingRobot.setCurrentState(updatedRobot.getCurrentState());
        return robotService.saveRobot(existingRobot);
    }

    // Видалити робота за ID
    @DeleteMapping("/{id}")
    public void deleteRobot(@PathVariable UUID id) {
        robotService.deleteRobot(id);
    }
}