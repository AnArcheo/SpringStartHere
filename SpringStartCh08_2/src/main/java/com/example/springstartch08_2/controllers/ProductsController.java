package com.example.springstartch08_2.controllers;

import com.example.springstartch08_2.services.ProductService;
import org.springframework.stereotype.Controller;

@Controller
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
}
