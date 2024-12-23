package com.project.IotManagement.IotMan;

import com.project.IotManagement.IotMan.TestData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")  // Endpoint: /api/test
public class TestController {

    @PostMapping
    public ResponseEntity<String> receiveData(@RequestBody TestData data) {
        System.out.println("Received data: " + data);
        return ResponseEntity.ok("Data received successfully");
    }
}
