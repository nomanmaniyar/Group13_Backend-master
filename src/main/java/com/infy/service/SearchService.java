package com.infy.service;

import java.util.List;

import com.infy.dto.RestaurantDTO;

public interface SearchService {
	
	public RestaurantDTO viewRestaurantDetails(Integer restaurantId) throws Exception;
	
	public List<RestaurantDTO> viewAllRestaurants() throws Exception;	
}
