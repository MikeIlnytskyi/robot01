package com.example.robots0_1.Service;

import com.example.robots0_1.enti.MaintenanceLogs;
import com.example.robots0_1.Repository.MaintenanceLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MaintenanceLogsService {

    private final MaintenanceLogsRepository maintenanceLogsRepository;

    @Autowired
    public MaintenanceLogsService(MaintenanceLogsRepository maintenanceLogsRepository) {
        this.maintenanceLogsRepository = maintenanceLogsRepository;
    }

    // Отримати всі записи
    public List<MaintenanceLogs> getAllMaintenanceLogs() {
        return maintenanceLogsRepository.findAll();
    }

    // Отримати запис за ID
    public MaintenanceLogs getMaintenanceLogById(UUID id) {
        return maintenanceLogsRepository.findById(id).orElse(null);
    }

    // Зберегти новий запис
    public MaintenanceLogs saveMaintenanceLog(MaintenanceLogs maintenanceLog) {
        return maintenanceLogsRepository.save(maintenanceLog);
    }

    // Оновити існуючий запис
    public MaintenanceLogs updateMaintenanceLog(UUID id, MaintenanceLogs updatedLog) {
        MaintenanceLogs existingLog = maintenanceLogsRepository.findById(id).orElse(null);
        if (existingLog == null) {
            throw new IllegalArgumentException("MaintenanceLog with ID " + id + " not found.");
        }
        existingLog.setRobotId(updatedLog.getRobotId());
        existingLog.setTimestamp(updatedLog.getTimestamp());
        existingLog.setDescription(updatedLog.getDescription());
        existingLog.setStatus(updatedLog.getStatus());
        return maintenanceLogsRepository.save(existingLog);
    }

    // Видалити запис
    public void deleteMaintenanceLog(UUID id) {
        maintenanceLogsRepository.deleteById(id);
    }
}

