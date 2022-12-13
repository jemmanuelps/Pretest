package com.example.demo.controllers;

import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Product;
import com.example.demo.models.ProductList;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/sortProducts")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductList sortProducts(@RequestBody ProductList productsToSort) {
        return new ProductList(productService.sortProducts(productsToSort.productList));
    }
}
