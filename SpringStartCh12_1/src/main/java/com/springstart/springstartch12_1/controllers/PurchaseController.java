package com.springstart.springstartch12_1.controllers;

import com.springstart.springstartch12_1.model.Purchase;
import com.springstart.springstartch12_1.repositories.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }
    //end point a client calls to store a purchase record in database
    //storePurchase() method persist the data the controllers action gets from
    //the http request body
    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase){
        purchaseRepository.storePurchase(purchase);
    }
    @GetMapping
    public List<Purchase> findPurchases(){
        return purchaseRepository.findAllPurchases();
    }
}
