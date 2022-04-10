package com.springstart.springstartch09_1.controllers;

import com.springstart.springstartch09_1.model.LoginProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {
    @Mock
    private Model model;
    @Mock
    private LoginProcessor loginProcessor;
    @InjectMocks
    private LoginController loginController;

    @Test
    void postLoginSucceed() {

        given(loginProcessor.login()).willReturn(true); //return true when login() is called

        String result = loginController.postLogin("username", "password", model);

        assertEquals("/login", result);

        verify(model).addAttribute("message", "You are now logged in.");
    }

    @Test
    void postLoginFailed() {

        given(loginProcessor.login()).willReturn(false); //return true when login() is called

        String result = loginController.postLogin("username", "password", model);

        assertEquals("/login", result);

        verify(model).addAttribute("message", "Login Failed");
    }
}