
package com.infy.service;


import java.util.List;
import com.infy.dto.DishDTO;
import com.infy.dto.RestaurantDTO;
import com.infy.repository.DishRatingRepository;
import com.infy.repository.DishRepository;
import com.infy.repository.RestaurantRepository;
import com.infy.repository.UsersRepository;



public class RestaurantRegisterServiceImpl implements RestaurantRegisterService {
	
	
	private RestaurantRepository restaurantRepository;
	
	
	private UsersRepository userRepository;
	
	
	private DishRepository dishRepository;
	
	
	private DishRatingRepository dishRatingRepository;
	
	public Integer registerNewRestaurant(RestaurantDTO restaurant,Integer userId) throws Exception {
		
		//Your code goes here
				return null;
		}
	
	
	
	@Override
	public Integer addDish(Integer restaurantId, DishDTO dish) throws Exception {
		//Your code goes here
				return null;
	}
	
	@Override
	public Integer updateDish(DishDTO dish, Integer restaurantId) throws Exception {
		
		//Your code goes here
				return null;	
	}
	

	@Override
	public void deleteDish(Integer restaurantId, Integer dishId) throws Exception {
	
		//Your code goes here
			
	}
	

	@Override
	public List<DishDTO> viewDishes(Integer restaurantId) throws Exception {
		//Your code goes here
				return null;
	}
	


	@Override
	public List<RestaurantDTO> viewRestaurants (Integer userId) throws Exception {
		//Your code goes here
			return null;
	}

}