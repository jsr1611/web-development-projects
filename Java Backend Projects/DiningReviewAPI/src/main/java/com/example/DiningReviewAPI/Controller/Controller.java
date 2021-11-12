package com.example.DiningReviewAPI.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String helloWorld(){
        return "Hello Dining Review API!";
    }
}
