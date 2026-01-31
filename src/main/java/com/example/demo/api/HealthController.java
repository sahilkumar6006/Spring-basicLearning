package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/status")
public class HealthController {

    // Constructor Injection (Production Standard)
    // No @Autowired needed here in modern Spring if there's only one constructor
    public HealthController() {}

    @GetMapping
    public Map<String, String> getStatus() {
        return Map.of(
            "status", "DELIVERING",
            "version", "1.0.0",
            "environment", "development"
        );
    }
}