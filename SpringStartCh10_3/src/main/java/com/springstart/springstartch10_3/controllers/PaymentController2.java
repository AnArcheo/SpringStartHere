package com.springstart.springstartch10_3.controllers;

import com.springstart.springstartch10_3.model.PaymentDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


// Controller to get data from the client in the request body

@RestController
public class PaymentController2 {

    private static Logger logger = Logger.getLogger(PaymentController2.class.getName());

    @PostMapping("/payment2")
    public ResponseEntity<PaymentDetails> makePayment(
            @RequestBody PaymentDetails paymentDetails){
        logger.info("Received Payment " + paymentDetails.getAmount());

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }

}
