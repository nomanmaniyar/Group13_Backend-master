package com.infy.service;

import java.util.List;

import com.infy.dto.RestaurantDTO;
import com.infy.dto.UsersDTO;

public interface RestaurantRecommendationService {

	public List<RestaurantDTO> getRecommendationByArea(String area) throws Exception;
	
	public UsersDTO getUser(Integer userId) throws Exception;
}
