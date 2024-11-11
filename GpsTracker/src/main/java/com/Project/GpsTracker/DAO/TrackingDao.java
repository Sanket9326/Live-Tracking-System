package com.Project.GpsTracker.DAO;

import com.Project.GpsTracker.Model.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TrackingDao extends JpaRepository<Tracking, Integer> {

    @Query(value = "SELECT latitude,longitude from Tracking WHERE device_id = :id AND timestamp >= :start AND timestamp <= :end",nativeQuery = true)
    List<List<String>> getData(@Param("id") String deviceId,@Param("start") LocalDateTime startDateTime,@Param("end") LocalDateTime endDateTime);

    @Query(value = "Select latitude,longitude from Tracking Where device_id = :id AND timestamp >= :time",nativeQuery = true)
    List<List<String>> getLiveData(@Param("id") String deviceId,@Param("time") Timestamp currTime);
}
