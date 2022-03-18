package com.springstart.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope // login scope
public class LoginProcessor {

    private String username;
    private String password;


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
        String username = this.getUsername();
        String password = this.getPassword();

        if("Anna".equals(username) && "password".equals(password)){
            return true;
        }else{
            return false;
        }
    }


}
