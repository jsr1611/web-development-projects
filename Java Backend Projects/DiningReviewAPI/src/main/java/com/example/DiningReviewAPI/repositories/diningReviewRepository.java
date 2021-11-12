package com.example.DiningReviewAPI.repositories;

import com.example.DiningReviewAPI.models.diningReview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface diningReviewRepository extends CrudRepository<diningReview, Long> {
}
