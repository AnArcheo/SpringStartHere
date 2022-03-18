package com.springstart.springstartch09_1.controllers;

import com.springstart.springstartch09_1.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String home(@RequestParam (required = false) String logout, Model model){

        if(logout != null){
            loggedUserManagementService.setUsername(null); // if logout param present - erase username
        }

        String username = loggedUserManagementService.getUsername();

        if(username == null){
            return "redirect:/";
        }

        model.addAttribute("username", username);
        return "/main";
    }
}
