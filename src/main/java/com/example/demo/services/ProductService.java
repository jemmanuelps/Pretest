package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.models.Product;

@Service
public class ProductService {
    public List<Product> sortProducts(List<Product> products) {
        return products.stream()
            .sorted((product1, product2) -> product2.getProductId().compareTo(product1.getProductId()))
            .collect(Collectors.toList());
    }
}
