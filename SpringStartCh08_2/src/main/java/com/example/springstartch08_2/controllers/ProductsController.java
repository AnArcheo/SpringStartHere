package com.example.springstartch08_2.controllers;

import com.example.springstartch08_2.model.Product;
import com.example.springstartch08_2.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }
    // HTTP GET
    @GetMapping("/products") // requestmapping by default uses http get method
    public String viewProducts(Model model){ // model param used to send data to view
        var products = productService.findAll(); // get the list of products from service
        model.addAttribute("products", products); //send the product list to view

        return "/products"; // return the view name that will be taken and rendered by dispatcher servlet
    }

    //HTTP POST (adding a product)
    @PostMapping(value = "/products")
    public String addProduct(Product product, Model model){ //Spring will know to create instance of Product

            productService.addProduct(product);

            //get the list of products and send it to the view
            var p = productService.findAll();
            model.addAttribute("products", p);

            return "/products"; // return the name of the view

//@RequestParam String name - replaced with Product param
//@RequestParam Double price - replaced with Product param

//        Product product = new Product();
//        product.setName(name);
//        product.setPrice(price);
            //add product
    }

}


