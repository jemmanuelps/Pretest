package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.AvailabilityStoreRequest;
import com.example.demo.models.AvailabilityStoreResponse;
import com.example.demo.services.AvailabilityService;

@Controller
@RequestMapping("/findStoreAvailability")
public class StoreAvailability {

    @Autowired
    private AvailabilityService availabilityService;

    @PostMapping
    public AvailabilityStoreResponse findStoreAvailability(@RequestBody AvailabilityStoreRequest storeRequest) {
        return availabilityService.findStoreAvailability(storeRequest);
    }
}
