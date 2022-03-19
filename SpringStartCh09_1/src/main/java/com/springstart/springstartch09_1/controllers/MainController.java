package com.springstart.springstartch09_1.controllers;

import com.springstart.springstartch09_1.services.LoggedUserManagementService;
import com.springstart.springstartch09_1.services.LoginCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    public MainController(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }

    @GetMapping("/main")
    public String home(@RequestParam (required = false) String logout, Model model){

        if(logout != null){
            loggedUserManagementService.setUsername(null); // if logout param present - erase username
        }

        String username = loggedUserManagementService.getUsername();
        //get count of login attempts
        int count = loginCountService.getCount();

        if(username == null){
            return "redirect:/";
        }

        model.addAttribute("username", username);
        model.addAttribute("loginCount", count);

        return "/main";
    }
}
