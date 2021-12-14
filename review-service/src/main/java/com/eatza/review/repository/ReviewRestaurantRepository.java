package com.eatza.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eatza.review.model.ReviewRestaurant;

public interface ReviewRestaurantRepository extends JpaRepository<ReviewRestaurant, Long> {

}
