package com.example.robots0_1.Repository;

import com.example.robots0_1.enti.TaskQueue;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskQueueRepository extends CassandraRepository<TaskQueue, UUID> {
    // Можна додати спеціалізовані методи пошуку за потреби
}
