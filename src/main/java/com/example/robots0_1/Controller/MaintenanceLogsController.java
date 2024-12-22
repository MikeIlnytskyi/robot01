package com.example.robots0_1.Controller;

import com.example.robots0_1.enti.MaintenanceLogs;
import com.example.robots0_1.Service.MaintenanceLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/maintenanceLogs")
public class MaintenanceLogsController {

    private final MaintenanceLogsService maintenanceLogsService;

    @Autowired
    public MaintenanceLogsController(MaintenanceLogsService maintenanceLogsService) {
        this.maintenanceLogsService = maintenanceLogsService;
    }

    // Отримати всі записи
    @GetMapping
    public List<MaintenanceLogs> getAllMaintenanceLogs() {
        return maintenanceLogsService.getAllMaintenanceLogs();
    }

    // Отримати запис за ID
    @GetMapping("/{id}")
    public MaintenanceLogs getMaintenanceLogById(@PathVariable UUID id) {
        return maintenanceLogsService.getMaintenanceLogById(id);
    }

    // Створити новий запис
    @PostMapping
    public MaintenanceLogs createMaintenanceLog(@RequestBody MaintenanceLogs maintenanceLog) {
        return maintenanceLogsService.saveMaintenanceLog(maintenanceLog);
    }

    // Оновити існуючий запис
    @PutMapping("/{id}")
    public MaintenanceLogs updateMaintenanceLog(@PathVariable UUID id, @RequestBody MaintenanceLogs updatedLog) {
        return maintenanceLogsService.updateMaintenanceLog(id, updatedLog);
    }

    // Видалити запис
    @DeleteMapping("/{id}")
    public void deleteMaintenanceLog(@PathVariable UUID id) {
        maintenanceLogsService.deleteMaintenanceLog(id);
    }
}

