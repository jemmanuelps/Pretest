package com.example.demo.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.models.Availability;
import com.example.demo.models.AvailabilityResponse;
import com.example.demo.models.AvailabilityStoreRequest;
import com.example.demo.models.AvailabilityStoreResponse;
import com.example.demo.models.Calendar;
import com.example.demo.models.Capacity;

@Service
public class AvailabilityService {
    public AvailabilityResponse getProdAvalibility(Availability availability) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        return null;
    }


    private List<Availability> getAvailability(String storeNo) {
        return createAvailabilityList().stream().filter(av -> av.getStoreNo().equals(storeNo)).collect(Collectors.toList());
    }
    
    private List<Capacity> getCapacity(String storeNo) {
        return createCapacityList().stream().filter(cap -> cap.getStoreNo().equals(storeNo)).collect(Collectors.toList());
    }

    private List<Availability> createAvailabilityList() {
        var availability1 = new Availability("Store001", "Prod1", 1.0, new Date("2021 - 02 - 19"));
        var availability2 = new Availability("Store001", "Prod1", 3.0, new Date("2021 - 02 - 20"));
        var availability3 = new Availability("Store001", "Prod1", 0.0, new Date("2021 - 02 - 21"));
        return List.of(availability1, availability2, availability3);
    }

    private List<Capacity> createCapacityList() {
        var capacity1 = new Capacity(" Store001", new Date("2021 - 02 - 19"), 0.0);
        var capacity2 = new Capacity(" Store001", new Date("2021 - 02 - 20"), 2.0);
        var capacity3 = new Capacity (" Store001", new Date("2021 - 02 - 21"), 2.0) ;
        return List.of(capacity1, capacity2, capacity3);
    }

    public AvailabilityStoreResponse findStoreAvailability(AvailabilityStoreRequest storeRequest) {
        var calendar = createCalendar();
        var storeFilter = calendar.stream().filter(filter -> filterCalendar(filter, storeRequest)).collect(Collectors.toList());
        var response = new AvailabilityStoreResponse();
        response.setLocationId(storeRequest.getLocationId());
        response.setRequestDate(storeRequest.getRequestDate());

        if (storeFilter.isEmpty()) {
            response.setStatus("Not Available");
        } else {
            response.setStatus("Available");
        }

        return response;
    }

    private List<Calendar> createCalendar() {
        var calendar1 = new Calendar("STORE001", "ALL", LocalTime.parse("13:30:00"));
        var calendar2 = new Calendar("STORE002", "SUNDAY",  LocalTime.parse("13:30:00"));
        var calendar3 = new Calendar("STORE003", "MONDAY", LocalTime.parse("13:30:00"));
        return List.of(calendar1, calendar2, calendar3);
    }

    private boolean filterCalendar(Calendar calendar, AvailabilityStoreRequest request) {
        var date = LocalDateTime.parse(request.getRequestDate());
        var dateToValidate = date.toLocalDate();
        var timeToValidate = date.toLocalTime();
        var dayOfWeek = dateToValidate.getDayOfWeek().toString();
        if (calendar.getDay().equals("ALL") && calendar.getLocationId().equals(request.getLocationId()) && calendar.getCutOffTime().compareTo(timeToValidate) > 0) {
            return true;
        } else if (calendar.getDay().equals(dayOfWeek) && calendar.getLocationId().equals(request.getLocationId()) && calendar.getCutOffTime().compareTo(timeToValidate) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
