package com.springstart.springstartch10_3.controllers;

import com.springstart.springstartch10_3.exceptions.NotEnoughMoneyException;
import com.springstart.springstartch10_3.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> exceptionNotEnoughMoneyHandler(){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not Enough Money To Make A Payment.");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
