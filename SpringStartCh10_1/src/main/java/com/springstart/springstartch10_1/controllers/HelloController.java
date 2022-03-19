package com.springstart.springstartch10_1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    //@ResponseBody // this method does not return a view but http response directly
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/ciao")
    //@ResponseBody //duplicated; to avoid this whole controller gets @RestController annotation
    public String ciao(){
        return "Ciao!";
    }
}
