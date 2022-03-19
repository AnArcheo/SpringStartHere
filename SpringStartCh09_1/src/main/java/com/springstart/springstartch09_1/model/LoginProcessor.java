package com.springstart.springstartch09_1.model;

import com.springstart.springstartch09_1.services.LoggedUserManagementService;
import com.springstart.springstartch09_1.services.LoginCountService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope // login scope
public class LoginProcessor {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    private String username;
    private String password;

    public LoginProcessor(LoggedUserManagementService loggedUserManagementService, LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(){  // bean defines a method for implementing the login logic
        loginCountService.increment(); // increment count for each login attempt

        String username = this.getUsername();
        String password = this.getPassword();

        boolean loginResult = false;

        if("Anna".equals(username) && "password".equals(password)){
            loginResult = true;
            loggedUserManagementService.setUsername(username); // store username on the LoggedUserManagementService bean
        }else{
            loginResult = false;
        }

        return loginResult;
    }


}
