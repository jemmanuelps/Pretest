package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Availability;
import com.example.demo.models.AvailabilityResponse;

@Controller
@RequestMapping("/getProdAvailability")
public class AvailabilityController {
    
    @PostMapping
    public AvailabilityResponse getProdAvailabilityResponse(@RequestBody Availability availability) {
        return null;
    }
}
