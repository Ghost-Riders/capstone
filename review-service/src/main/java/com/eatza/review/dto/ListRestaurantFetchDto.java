package com.eatza.review.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ListRestaurantFetchDto {

	private List<RestaurantFetchDto> list;

}
