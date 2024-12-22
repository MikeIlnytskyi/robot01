package com.example.robots0_1.Service;

import com.example.robots0_1.enti.Diagnostics;
import com.example.robots0_1.Repository.DiagnosticsRepository;
import com.example.robots0_1.enti.Robots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DiagnosticsService {

    private final DiagnosticsRepository diagnosticsRepository;
    private final RobotService robotService;

    @Autowired
    public DiagnosticsService(DiagnosticsRepository diagnosticsRepository, RobotService robotService) {
        this.diagnosticsRepository = diagnosticsRepository;
        this.robotService = robotService;
    }

    // Отримати всі діагностики
    public List<Diagnostics> getAllDiagnostics() {
        return diagnosticsRepository.findAll();
    }

    // Отримати діагностику за унікальним ID діагностики
    public Diagnostics getDiagnosticById(UUID diagnosticId) {
        return diagnosticsRepository.findById(diagnosticId)
                .orElseThrow(() -> new IllegalArgumentException("Diagnostic with ID " + diagnosticId + " not found."));
    }

    // Отримати всі діагностики для конкретного робота за його ID
    public List<Diagnostics> getDiagnosticsByRobotId(UUID robotId) {
        return diagnosticsRepository.findByRobotId(robotId);
    }

    // Додати нову діагностику
    public Diagnostics saveDiagnostic(Diagnostics diagnostic) {
        return diagnosticsRepository.save(diagnostic);
    }

    // Оновити існуючу діагностику
    public Diagnostics updateDiagnostic(UUID id, Diagnostics updatedDiagnostic) {
        Diagnostics existingDiagnostic = getDiagnosticById(id); // Отримати існуючу діагностику
        existingDiagnostic.setRobotId(updatedDiagnostic.getRobotId());
        existingDiagnostic.setDiagnosticTime(updatedDiagnostic.getDiagnosticTime());
        existingDiagnostic.setStatus(updatedDiagnostic.getStatus());
        existingDiagnostic.setDetails(updatedDiagnostic.getDetails());
        return diagnosticsRepository.save(existingDiagnostic);
    }

    // Видалити діагностику
    public void deleteDiagnostic(UUID id) {
        if (!diagnosticsRepository.existsById(id)) {
            throw new IllegalArgumentException("Diagnostic with ID " + id + " not found.");
        }
        diagnosticsRepository.deleteById(id);
    }


    // Отримати робота за robotId
    public Robots getRobotById(UUID robotId) {
        return robotService.getRobotById(robotId);
    }

}
