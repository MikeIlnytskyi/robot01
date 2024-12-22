package com.example.robots0_1.Repository;

import com.example.robots0_1.enti.MovementHistory;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovementHistoryRepository extends CassandraRepository<MovementHistory, UUID> {
    // Можна додати додаткові методи пошуку, якщо потрібно
}

