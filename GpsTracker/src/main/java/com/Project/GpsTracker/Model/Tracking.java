package com.Project.GpsTracker.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
public class Tracking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int trackingId;

    @NotEmpty(message = "Device Id cannot be empty")
    private String deviceId;

    @NotEmpty(message = "latitude cannot be empty!")
    private String latitude;

    @NotEmpty(message = "Longitude cannot be empty!")
    private String longitude;

    private Timestamp timestamp;
}
