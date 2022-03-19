package com.springstart.springstartch10_3.controllers;

import com.springstart.springstartch10_3.exceptions.NotEnoughMoneyException;
import com.springstart.springstartch10_3.model.ErrorDetails;
import com.springstart.springstartch10_3.model.PaymentDetails;
import com.springstart.springstartch10_3.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(){
        // try calling processPayment() method
        try{
            PaymentDetails paymentDetails = paymentService.processPayment();
            //if calling the service succeed it will return HTTP response with status Accepted
            //and the paymentDetails instance as a response body
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        } catch (NotEnoughMoneyException e){
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make a payment.");
            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }
    }

}
