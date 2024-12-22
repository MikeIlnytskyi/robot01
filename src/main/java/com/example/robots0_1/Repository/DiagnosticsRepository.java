package com.example.robots0_1.Repository;

import com.example.robots0_1.enti.Diagnostics;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiagnosticsRepository extends CassandraRepository<Diagnostics, UUID> {
    List<Diagnostics> findByRobotId(UUID robotId);
}
