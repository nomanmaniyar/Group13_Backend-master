package com.infy.service;


import java.util.List;
import com.infy.dto.RestaurantDTO;
import com.infy.dto.UsersDTO;
import com.infy.repository.RestaurantRepository;
import com.infy.repository.UsersRepository;


public class RestaurantRecommendationServiceImpl implements RestaurantRecommendationService {

	
	
	private RestaurantRepository restaurantRepository;
	
	
	private UsersRepository userRepository;

	@Override
	public List<RestaurantDTO> getRecommendationByArea(String area) throws Exception {	

		//Your code goes here
				return null;
	}

	@Override
	public UsersDTO getUser(Integer userId) throws Exception {

		//Your code goes here
				return null;
	}

}
