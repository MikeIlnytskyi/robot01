package com.example.robots0_1.Controller;

import com.example.robots0_1.enti.MovementHistory;
import com.example.robots0_1.Service.MovementHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/movementHistory")
public class MovementHistoryController {

    private final MovementHistoryService movementHistoryService;

    @Autowired
    public MovementHistoryController(MovementHistoryService movementHistoryService) {
        this.movementHistoryService = movementHistoryService;
    }

    // Отримати всі записи
    @GetMapping
    public List<MovementHistory> getAllMovementHistories() {
        return movementHistoryService.getAllMovementHistories();
    }

    // Отримати запис за ID
    @GetMapping("/{id}")
    public MovementHistory getMovementHistoryById(@PathVariable UUID id) {
        return movementHistoryService.getMovementHistoryById(id);
    }

    // Створити новий запис
    @PostMapping
    public MovementHistory createMovementHistory(@RequestBody MovementHistory movementHistory) {
        return movementHistoryService.saveMovementHistory(movementHistory);
    }

    // Оновити запис
    @PutMapping("/{id}")
    public MovementHistory updateMovementHistory(@PathVariable UUID id, @RequestBody MovementHistory updatedMovementHistory) {
        return movementHistoryService.updateMovementHistory(id, updatedMovementHistory);
    }

    // Видалити запис
    @DeleteMapping("/{id}")
    public void deleteMovementHistory(@PathVariable UUID id) {
        movementHistoryService.deleteMovementHistory(id);
    }
}
