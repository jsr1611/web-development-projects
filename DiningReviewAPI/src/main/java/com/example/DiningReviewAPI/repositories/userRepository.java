package com.example.DiningReviewAPI.repositories;

import com.example.DiningReviewAPI.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends CrudRepository<User, Long> {

}
