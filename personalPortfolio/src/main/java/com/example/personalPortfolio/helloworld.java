package com.example.personalPortfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworld {

    @GetMapping("/")
    public String helloWorld() {
        return "Welcome to my personal portfolio project!" +
                "Here, I hope to present the skills and technologies I learned about Java Spring Framework as much as possible.";
    }
}
