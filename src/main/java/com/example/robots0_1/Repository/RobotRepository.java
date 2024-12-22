package com.example.robots0_1.Repository;

import com.example.robots0_1.enti.Robots;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface RobotRepository extends CassandraRepository<Robots, UUID> {

    @Query("SELECT * FROM robots WHERE model = :model ALLOW FILTERING")
    List<Robots> findByModel(@Param("model") String model);

    @Query("SELECT * FROM robots WHERE serial_number = :serialNumber ALLOW FILTERING")
    List<Robots> findBySerialNumber(@Param("serialNumber") String serialNumber);

    @Query("SELECT * FROM robots WHERE battery_level = :batteryLevel ALLOW FILTERING")
    List<Robots> findByBatteryLevel(@Param("batteryLevel") Integer batteryLevel);

    @Query("SELECT * FROM robots WHERE current_state = :currentState ALLOW FILTERING")
    List<Robots> findByCurrentState(@Param("currentState") String currentState);

}

