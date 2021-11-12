package com.example.DiningReviewAPI.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DINING_REVIEW")
public @Data
class diningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "reviewer_name")
    private String reviewerName;

    @Column(name = "restaurant_id")
    private Long restaurandId;

    // scores are on a scale of 1-5
    @Column(name = "peanut_score")
    private Integer peanutScore;

    @Column(name = "egg_score")
    private Integer eggScore;

    @Column(name = "dairy_score")
    private Integer dairyScore;

    @Column(name = "commentary")
    private String commentary;

}
