package com.example.demo.models;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Calendar {
    public String locationId;
    public String day;
    public LocalTime cutOffTime;
}
