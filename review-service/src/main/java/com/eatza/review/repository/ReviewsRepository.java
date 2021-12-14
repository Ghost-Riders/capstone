package com.eatza.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eatza.review.model.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

}
