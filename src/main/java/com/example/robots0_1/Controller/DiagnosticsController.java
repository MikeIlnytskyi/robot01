package com.example.robots0_1.Controller;

import com.example.robots0_1.enti.Diagnostics;
import com.example.robots0_1.Service.DiagnosticsService;
import com.example.robots0_1.enti.Robots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/diagnostics")
public class DiagnosticsController {

    private final DiagnosticsService diagnosticsService;

    @Autowired
    public DiagnosticsController(DiagnosticsService diagnosticsService) {
        this.diagnosticsService = diagnosticsService;
    }

    // Отримати список всіх діагностик
    @GetMapping("/")
    public String getAllDiagnostics(Model model) {
        List<Diagnostics> diagnosticsList = diagnosticsService.getAllDiagnostics();
        model.addAttribute("diagnostics", diagnosticsList);
        return "diagnostics-list"; // Назва HTML-сторінки
    }

    // Отримати всі діагностики для конкретного робота за його ID
    @GetMapping("/robot/{robotId}")
    public String getDiagnosticsByRobotId(@PathVariable UUID robotId, Model model) {
        List<Diagnostics> diagnostics = diagnosticsService.getDiagnosticsByRobotId(robotId);
        model.addAttribute("diagnostics", diagnostics);
        model.addAttribute("robotId", robotId); // Для виводу ID робота
        return "diagnostics-list"; // Сторінка зі списком діагностик
    }

    // Показати форму для додавання нової діагностики
    @GetMapping("/add")
    public String showAddDiagnosticForm(Model model) {
        model.addAttribute("diagnostic", new Diagnostics());
        return "add-diagnostics"; // Назва HTML-сторінки
    }

    // Обробити додавання нової діагностики
    @PostMapping("/add")
    public String addDiagnostic(@ModelAttribute Diagnostics diagnostic) {
        diagnosticsService.saveDiagnostic(diagnostic);
        return "redirect:/diagnostics/"; // Повертаємося до списку
    }

    // Показати форму для редагування існуючої діагностики
    @GetMapping("/edit/{id}")
    public String showEditDiagnosticForm(@PathVariable UUID id, Model model) {
        Diagnostics diagnostic = diagnosticsService.getDiagnosticById(id);
        model.addAttribute("diagnostic", diagnostic);
        return "edit-diagnostics"; // Назва HTML-сторінки
    }

    // Обробити оновлення діагностики
    @PostMapping("/edit/{id}")
    public String updateDiagnostic(@PathVariable UUID id, @ModelAttribute Diagnostics diagnostic) {
        diagnosticsService.updateDiagnostic(id, diagnostic);
        return "redirect:/diagnostics/";
    }

    // Видалити діагностику
    @GetMapping("/delete/{id}")
    public String deleteDiagnostic(@PathVariable UUID id) {
        diagnosticsService.deleteDiagnostic(id);
        return "redirect:/diagnostics/";
    }

    @GetMapping("/details/{diagnosticId}")
    public String getDiagnosticDetails(@PathVariable UUID diagnosticId, Model model) {
        Diagnostics diagnostic = diagnosticsService.getDiagnosticById(diagnosticId);
        if (diagnostic != null) {
            Robots robot = diagnosticsService.getRobotById(diagnostic.getRobotId());
            model.addAttribute("diagnostic", diagnostic);
            model.addAttribute("robot", robot);
        }
        return "diagnostic-details"; // Назва HTML-сторінки для відображення
    }
    @GetMapping("/diagnostics/robot/{robotId}")
    public String getDiagnosticsForRobot(@PathVariable UUID robotId, Model model) {
        List<Diagnostics> diagnostics = diagnosticsService.getDiagnosticsByRobotId(robotId);
        Robots robot = diagnosticsService.getRobotById(robotId);
        model.addAttribute("diagnostics", diagnostics);
        model.addAttribute("robot", robot);
        return "diagnostics-for-robot"; // Назва HTML-шаблону
    }

}
