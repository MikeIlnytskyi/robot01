package com.example.robots0_1.Service;
import com.example.robots0_1.Repository.RobotRepository;
import com.example.robots0_1.enti.Robots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RobotService {
    private final RobotRepository robotRepository;

    @Autowired
    public RobotService(RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }

    public List<Robots> getAllRobots() {
        return robotRepository.findAll();
    }

    public Robots getRobotById(UUID robotId) {
        return robotRepository.findById(robotId).orElse(null);
    }

    public Robots saveRobot(Robots robots) {
        // Логіка: наприклад, перевірка батареї перед збереженням
        return robotRepository.save(robots);
    }

    public void deleteRobot(UUID robotId) {
        robotRepository.deleteById(robotId);
    }



    public List<Robots> searchRobots(String model, String serialNumber, Integer batteryLevel, String currentState) {
        if (model != null && !model.isEmpty()) {
            return robotRepository.findByModel(model);
        } else if (serialNumber != null && !serialNumber.isEmpty()) {
            return robotRepository.findBySerialNumber(serialNumber);
        } else if (batteryLevel != null) {
            return robotRepository.findByBatteryLevel(batteryLevel);
        } else if (currentState != null && !currentState.isEmpty()) {
            return robotRepository.findByCurrentState(currentState);
        } else {
            return robotRepository.findAll(); // Якщо нічого не передано, повернути всі записи
        }
    }

}


