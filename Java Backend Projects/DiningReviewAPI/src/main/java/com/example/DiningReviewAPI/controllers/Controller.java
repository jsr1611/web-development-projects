package com.example.DiningReviewAPI.controllers;

import com.example.DiningReviewAPI.models.Restaurant;
import com.example.DiningReviewAPI.repositories.diningReviewRepository;
import com.example.DiningReviewAPI.repositories.restaurantRepository;
import com.example.DiningReviewAPI.repositories.userRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Controller {
    final restaurantRepository restaurantRepo;
    final userRepository userRepo;
    final diningReviewRepository diningReviewRepo;
    final int adminId = 111;

    public Controller(restaurantRepository restaurantRepo, userRepository userRepo, diningReviewRepository diningReviewRepo) {
        this.restaurantRepo = restaurantRepo;
        this.userRepo = userRepo;
        this.diningReviewRepo = diningReviewRepo;
    }


    @GetMapping("/")
    public String index(){
        return "Welcome to Dining Review API Project home page!";
    }

    @GetMapping("/{restaurantId}")
    public Restaurant getRestaurant(@PathVariable Long restaurantId){
        Restaurant restaurant;
        Optional<Restaurant> restaurantOptional = restaurantRepo.findById(restaurantId);
        if(restaurantOptional.isPresent()){
            System.out.print("Restaurant with the id: " + restaurantId +" was found in the database!\n" );
            restaurant = restaurantOptional.get();
        }
        else {
            System.out.print("Restaurant with the id: " + restaurantId +" was not found in the database!\n" );
            restaurant = new Restaurant();
        }
        return restaurant;
    }

    @GetMapping("/admin/{adminId}/addRestaurant/")
    public String addRestaurant(@PathVariable Integer adminId){
        if(adminId == this.adminId){
            Restaurant restaurant;
            String name = "Nur";
            String city = "Toshkent";
            Integer capacity = 50;
            Integer numMenus = 10;


            restaurant = new Restaurant(0001L, name, city, capacity,capacity, numMenus,  0.0, 0.0, 0.0, 0.0);
            System.out.println(restaurant.getId());
            if(restaurant.getId() == null){
                return "Restaurant ID was null!";
            }
            Optional<Restaurant> optional =restaurantRepo.findById(restaurant.getId());
            if(optional.isEmpty()){
                restaurantRepo.save(restaurant);
                return  "SUCCESS\n'" + restaurant.getName() + "' was added\n" + restaurant;
            }
            else {
                return  "FAILURE. DUPLICATE ENTRY. \n'" + restaurant.getName() + "' was not added to the database. \n" + restaurant;
            }
        }
        else {
            return "Wrong admin ID: " + adminId + "!";
        }

    }

}
