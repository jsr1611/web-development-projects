package com.example.DiningReviewAPI.models;

import ch.qos.logback.classic.boolex.GEventEvaluator;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public @Data class user {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "display_name", unique = true)
    private String displayName;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "has_peanut_allergy")
    private Boolean hasPeanutAllergy;

    @Column(name = "has_egg_allergy")
    private Boolean hasEggAllergy;

    @Column(name = "has_dairy_allergy")
    private Boolean hasDairyAllergy;

}
