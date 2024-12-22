package com.example.robots0_1.Controller;

import com.example.robots0_1.enti.Robots;
import com.example.robots0_1.Service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.tools.Diagnostic;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/robots")
public class WebController {

    private final RobotService robotService;

    @Autowired
    public WebController(RobotService robotService) {
        this.robotService = robotService;
    }

    @GetMapping("/")
    public String home() {
        return "index"; // Назва файлу index.html у папці templates
    }

    @GetMapping
    public String getAllRobots(Model model) {
        List<Robots> robots = robotService.getAllRobots();
        model.addAttribute("robots", robots);
        return "robots-list"; // Назва HTML-сторінки
    }

    @GetMapping("/add")
    public String showAddRobotForm(Model model) {
        model.addAttribute("robot", new Robots());
        return "add-robot";
    }

    @GetMapping("/{id}")
    public String getRobotDetails(@PathVariable UUID id, Model model) {
        Robots robot = robotService.getRobotById(id);
        model.addAttribute("robot", robot);
        return "robot-details"; // Назва нової HTML-сторінки
    }

    @PostMapping("/add")
    public String addRobot(@ModelAttribute Robots robot) {
        robotService.saveRobot(robot);
        return "redirect:/robots"; // Перенаправлення на список роботів
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable UUID id, Model model) {
        Robots robot = robotService.getRobotById(id);
        model.addAttribute("robot", robot);
        return "edit-robot";
    }

    @PostMapping("/edit/{id}")
    public String updateRobot(@PathVariable UUID id, @ModelAttribute Robots robot) {
        robot.setRobotId(id); // Переконайтеся, що ID зберігається
        robotService.saveRobot(robot);
        return "redirect:/robots";
    }

    @GetMapping("/delete/{id}")
    public String deleteRobot(@PathVariable UUID id) {
        robotService.deleteRobot(id);
        return "redirect:/robots";
    }



    @GetMapping("/search")
    public String searchRobots(
            @RequestParam(value = "model", required = false) String model,
            @RequestParam(value = "serialNumber", required = false) String serialNumber,
            @RequestParam(value = "batteryLevel", required = false) Integer batteryLevel,
            @RequestParam(value = "currentState", required = false) String currentState,
            Model modelAttr) {

        List<Robots> robots = robotService.searchRobots(model, serialNumber, batteryLevel, currentState);
        modelAttr.addAttribute("robots", robots);
        return "robots-list";
    }


}
