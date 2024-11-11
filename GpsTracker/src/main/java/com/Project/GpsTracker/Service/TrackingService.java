package com.Project.GpsTracker.Service;

import com.Project.GpsTracker.DAO.TrackingDao;
import com.Project.GpsTracker.Model.Tracking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrackingService {
    @Autowired
    private TrackingDao trackingDao;

    public ResponseEntity<String> putData(String deviceId, String latitude, String longitude, Timestamp timestamp) {
        try{
            Tracking data = new Tracking();
            data.setDeviceId(deviceId);
            data.setLatitude(latitude);
            data.setLongitude(longitude);
            data.setTimestamp(timestamp);
            trackingDao.save(data);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<List<List<String>>> getData(String deviceId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
       try{
           List<List<String>> coordinates = trackingDao.getData(deviceId,startDateTime,endDateTime);
           return new ResponseEntity<>(coordinates, HttpStatus.OK);
       }catch (Exception e){
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    public ResponseEntity<List<List<String>>> getLiveData(String device, Timestamp timestamp) {
        try{
            List<List<String>> data = trackingDao.getLiveData(device,timestamp);
            return new ResponseEntity<>(data, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
