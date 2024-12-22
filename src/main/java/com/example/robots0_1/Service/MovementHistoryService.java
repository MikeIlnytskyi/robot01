package com.example.robots0_1.Service;

import com.example.robots0_1.enti.MovementHistory;
import com.example.robots0_1.Repository.MovementHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovementHistoryService {

    private final MovementHistoryRepository movementHistoryRepository;

    @Autowired
    public MovementHistoryService(MovementHistoryRepository movementHistoryRepository) {
        this.movementHistoryRepository = movementHistoryRepository;
    }

    // Отримати всі записи
    public List<MovementHistory> getAllMovementHistories() {
        return movementHistoryRepository.findAll();
    }

    // Отримати запис за ID
    public MovementHistory getMovementHistoryById(UUID id) {
        return movementHistoryRepository.findById(id).orElse(null);
    }

    // Зберегти новий запис
    public MovementHistory saveMovementHistory(MovementHistory movementHistory) {
        return movementHistoryRepository.save(movementHistory);
    }

    // Оновити запис
    public MovementHistory updateMovementHistory(UUID id, MovementHistory updatedMovementHistory) {
        MovementHistory existingHistory = movementHistoryRepository.findById(id).orElse(null);
        if (existingHistory == null) {
            throw new IllegalArgumentException("MovementHistory with ID " + id + " not found.");
        }
        existingHistory.setRobotId(updatedMovementHistory.getRobotId());
        existingHistory.setTimestamp(updatedMovementHistory.getTimestamp());
        existingHistory.setLocation(updatedMovementHistory.getLocation());
        existingHistory.setAction(updatedMovementHistory.getAction());
        return movementHistoryRepository.save(existingHistory);
    }

    // Видалити запис
    public void deleteMovementHistory(UUID id) {
        movementHistoryRepository.deleteById(id);
    }
}
