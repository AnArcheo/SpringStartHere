package com.springstart.springstartch10_2.controller;

import com.springstart.springstartch10_2.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public Country france(){
        Country country = Country.of("France", 67);
        return country;
    }

    //return a collection
    @GetMapping("/all")
    public List<Country> countries(){
        Country c1 = Country.of("France", 67);
        Country c2 = Country.of("Spain", 47);
        return List.of(c1, c2); //returns a collection in the HTTP response body
    }

    //added custom header and setting response status
    @GetMapping("/germany")
    public ResponseEntity<Country> germany(){
        Country c = Country.of("Germany", 60);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "Berlin")
                .header("favourite_food", "beer")
                .body(c);
    }
}
