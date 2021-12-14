package com.eatza.review.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "review_restaurants")
@Getter
@Setter
@NoArgsConstructor
public class ReviewRestaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String location;
	private String cuisine;
	private int budget;
	private double rating;

	@OneToMany
	@JoinColumn(name = "reviewId", nullable = false)
	private List<Reviews> userReviews;

	public ReviewRestaurant(String name, String location, String cuisine, int budget, double rating) {
		this.name = name;
		this.location = location;
		this.cuisine = cuisine;
		this.budget = budget;
		this.rating = rating;
	}
}
