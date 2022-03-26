package com.springstart.springstartch13_1.controllers;

import com.springstart.springstartch13_1.model.Account;
import com.springstart.springstartch13_1.model.TransferRequest;
import com.springstart.springstartch13_1.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//defines the endpoints that expose the service methods
@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    //POST method for the /transfer endpoint
    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request){
        transferService.transferMoney(request.getSenderAccountId(),
                request.getReceiverAccountId(), request.getAmount());
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return transferService.getAllAccounts();
    }
}
