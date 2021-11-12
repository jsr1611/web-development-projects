package com.example.DiningReviewAPI.repositories;

import com.example.DiningReviewAPI.models.DiningReview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface diningReviewRepository extends CrudRepository<DiningReview, Long> {
}
