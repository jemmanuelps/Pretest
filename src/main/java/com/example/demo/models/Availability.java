package com.example.demo.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Availability {
    public String storeNo;
    public String productId;
    public Double availQty;
    public Date date;
}
