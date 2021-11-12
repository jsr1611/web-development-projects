package com.example.DiningReviewAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String helloWorld(){
        System.out.println("Hello Dining Review API!");
        return "Hello Dining Review API!";
    }
}
