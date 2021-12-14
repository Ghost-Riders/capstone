package com.eatza.review.service.reviewsservice;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eatza.review.dto.ListRestaurantFetchDto;
import com.eatza.review.repository.ReviewRestaurantRepository;

@Service
public class ReviewsServiceImpl implements ReviewsServices {

	@Autowired
	private ReviewRestaurantRepository reviewRestaurantRepository;

	@Value("${restaurant.search.url}")
	private String restaurantServiceUrl;

	@Autowired
	RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(ReviewsServiceImpl.class);

	@Override
	public ListRestaurantFetchDto findAllRestaurants() {
		MappingJackson2HttpMessageConverter map = new MappingJackson2HttpMessageConverter();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		messageConverters.add(map);
		messageConverters.add(new FormHttpMessageConverter());
		restTemplate.setMessageConverters(messageConverters);
		ListRestaurantFetchDto list = null;
		try {
			list = restTemplate.getForObject(restaurantServiceUrl, ListRestaurantFetchDto.class);
		} catch (Exception e) {
			logger.error("list not found: " + e.getLocalizedMessage());
		}

		return list;
	}

}
