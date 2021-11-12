package com.example.DiningReviewAPI.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANT")
public @Data class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "available_seats")
    private Integer availableSeats;

    @Column(name = "num_menus")
    private Integer numMenus;

    @Column(name = "peanut_score")
    private Double peanutScore;

    @Column(name = "egg_score")
    private Double eggScore;

    @Column(name = "dairy_score")
    private Double dairyScore;

    @Column(name = "avg_score")
    private Double avgScore;

    public Restaurant(){}
    public Restaurant(String name, String city, Integer capacity, Integer numMenus) {
        this.name = name;
        this.city = city;
        this.capacity = capacity;
        this.availableSeats = capacity;
        this.numMenus = numMenus;
    }

}
