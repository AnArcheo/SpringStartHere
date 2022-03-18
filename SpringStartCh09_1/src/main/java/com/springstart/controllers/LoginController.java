package com.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/") // controller action to the root "/" path of the application
    public String getLogin(){
        return "/login";
    }
    @PostMapping("/")
    public String postLogin(
            @RequestParam String name,
            @RequestParam String password,
            Model model){

        boolean loggedIn = false;

        if(loggedIn){
            model.addAttribute("message", "You are logged in.");
        }else{
            model.addAttribute("message", "Login Failed");
        }
        return "/login";
    }
}
