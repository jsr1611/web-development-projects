package com.example.DiningReviewAPI.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DINING_REVIEW")
public @Data
class DiningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "status")
    private String status;

    private enum statuses{
        SUBMITTED,
        IN_REVIEW,
        ACCEPTED,
        REJECTED
    }

    public void setStatusFromEnum(Integer index){
        switch (index){
            case 0:
                this.status = statuses.SUBMITTED.toString();
                break;
            case 1:
                this.status = statuses.IN_REVIEW.toString();
                break;
            case 2:
                this.status = statuses.ACCEPTED.toString();
                break;
            case 3:
                this.status = statuses.REJECTED.toString();
        }
    }

}
