package com.Project.GpsTracker.Controller;

import com.Project.GpsTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody Map<String,String> map) {
        String email = map.get("username");
        String password = map.get("password");
        boolean loginSuccessful = userService.login(email, password);
        Map<String, String> response = new HashMap<>();

        if (loginSuccessful) {
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Login failed");
            return ResponseEntity.status(401).body(response);
        }

    }
    @ResponseBody
    @PutMapping("/new")
    public ResponseEntity<String> addUser(@RequestBody Map<String,String> map) {
        return userService.addUser(map.get("email"),map.get("password"));
    }
}
