package com.example.DiningReviewAPI.repositories;

import com.example.DiningReviewAPI.models.restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface restaurantRepository extends CrudRepository<restaurant, Long> {
}
