package com.example.DiningReviewAPI.repositories;

import com.example.DiningReviewAPI.models.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface restaurantRepository extends CrudRepository<Restaurant, Long> {
}
