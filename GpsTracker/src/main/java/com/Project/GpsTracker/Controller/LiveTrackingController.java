package com.Project.GpsTracker.Controller;


import com.Project.GpsTracker.Service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RequestMapping("/live")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LiveTrackingController  {

    @Autowired
    TrackingService trackingService;

    @GetMapping("/track")
    public ResponseEntity<List<List<String>>> getLiveData(@RequestParam String device,@RequestParam String timestamp){
        return trackingService.getLiveData(device, Timestamp.valueOf(timestamp));
    }

}
