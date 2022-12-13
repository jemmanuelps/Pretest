package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class Product {
    public String productId;
    public String productName;
    public String unitOfMeasure;
    public Date launchDate;
}
