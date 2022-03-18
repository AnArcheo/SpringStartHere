package com.springstart.springstartch09_1.controllers;

import com.springstart.springstartch09_1.model.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }


    @GetMapping("/") // controller action to the root "/" path of the application
    public String getLogin(){
        return "/login";
    }


    @PostMapping("/")
    public String postLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model){

        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        boolean loggedIn = loginProcessor.login();

        if(loggedIn){
            return "redirect:/main"; //when successfully authenticated app redirects to main page
        }
        model.addAttribute("message", "Login Failed");

        return "/login";
    }
}
