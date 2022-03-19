package com.springstart.springstartch10_3.services;

import com.springstart.springstartch10_3.exceptions.NotEnoughMoneyException;
import com.springstart.springstartch10_3.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }
}
