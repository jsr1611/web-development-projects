package com.example.DiningReviewAPI.repositories;

import com.example.DiningReviewAPI.models.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends CrudRepository<user, Long> {

}
