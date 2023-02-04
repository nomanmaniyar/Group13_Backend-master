package com.infy.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.infy.dto.RestaurantDTO;
import com.infy.service.RestaurantRecommendationService;

@RequestMapping
public class RestaurantRecommendationAPI {

	@Autowired
	private RestaurantRecommendationService recommendationService;

	@GetMapping
	public ResponseEntity<List<RestaurantDTO>> getRecommendationByArea(String area) throws Exception {

		// Your code goes here
		return null;

	}

}