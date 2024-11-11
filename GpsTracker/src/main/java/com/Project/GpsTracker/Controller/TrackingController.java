package com.Project.GpsTracker.Controller;

import com.Project.GpsTracker.Service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/data")
public class TrackingController {
    @Autowired
    private TrackingService trackingService;

    @PutMapping("/put")
    public ResponseEntity<String> putData(@RequestParam String deviceId,
                                          @RequestParam String latitude,
                                          @RequestParam String longitude,
                                          @RequestParam String timestamp) {

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.parse(timestamp, formatter);
        Timestamp parsedTimestamp = Timestamp.valueOf(localDateTime);

        return trackingService.putData(deviceId, latitude, longitude, parsedTimestamp);
    }

    @GetMapping("/get")
    public ResponseEntity<List<List<String>>> getData(@RequestParam String deviceId,@RequestParam String startTime,@RequestParam String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);
        return trackingService.getData(deviceId,startDateTime,endDateTime);
    }
}
