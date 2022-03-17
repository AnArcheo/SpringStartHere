package com.example.springstartch08_2.controllers;

import com.example.springstartch08_2.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
    @RequestMapping("/products") // requestmapping by default uses http get method
    public String viewProducts(Model model){ // model param used to send data to view
        var products = productService.findAll(); // get the list of products from service
        model.addAttribute("products", products); //send the product list to view

        return "/products"; // return the view name that will be taken and rendered by dispatcher servlet
    }
}
