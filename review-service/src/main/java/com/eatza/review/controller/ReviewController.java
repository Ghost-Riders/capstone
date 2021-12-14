package com.eatza.review.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eatza.review.dto.ListRestaurantFetchDto;
import com.eatza.review.service.reviewsservice.ReviewsServices;

import javassist.NotFoundException;

@RestController
public class ReviewController {

	@Autowired
	private ReviewsServices reviewsServices;

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

	@GetMapping("/restaurants")
	public ResponseEntity<ListRestaurantFetchDto> getAllRestaurants(@RequestHeader String authorization,
			@RequestParam(defaultValue = "1") int pagenumber, @RequestParam(defaultValue = "10") int pagesize)
			throws NotFoundException {
		logger.debug("In getall restaurants method");
//		if (pagenumber <= 0 || pagesize <= 0) {
//			logger.debug("Page number or size cannot be zero or less, throwing exception");
//			throw new RestaurantBadRequestException(RESTAURANT_BAD_REQUEST_MSG);
//		}
//		logger.debug("calling service to get restaurants with pagination");
		ListRestaurantFetchDto responseDto = reviewsServices.findAllRestaurants();
		if (responseDto.getList().isEmpty()) {
			logger.debug("No restaurants were found");
			throw new NotFoundException("Not Found exception");
		}

		return ResponseEntity.status(HttpStatus.OK).body(responseDto);

	}

}
