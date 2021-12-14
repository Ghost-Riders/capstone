package com.eatza.review.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
public class Reviews {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String rating;
	private int userId;
	private String userComment;

	public Reviews(String rating, int userId, String userComment) {
		super();
		this.rating = rating;
		this.userId = userId;
		this.userComment = userComment;
	}

}
