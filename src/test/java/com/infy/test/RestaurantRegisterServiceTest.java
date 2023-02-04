package com.infy.test;



import org.junit.jupiter.api.Test;

import com.infy.repository.DishRatingRepository;
import com.infy.repository.DishRepository;
import com.infy.repository.RestaurantRepository;
import com.infy.repository.UsersRepository;
import com.infy.service.RestaurantRegisterService;
import com.infy.service.RestaurantRegisterServiceImpl;


public class RestaurantRegisterServiceTest {
	
	
	private RestaurantRepository restaurantRepository;
	
	
	private UsersRepository userRepository;
	
	
	private DishRepository dishRepository;
	
	
	private DishRatingRepository dishRatingRepository;
	
	
	private RestaurantRegisterService resRegisterService = new RestaurantRegisterServiceImpl();

	@Test
	public void registerNewRestaurantValidTest() throws Exception{
		
		//Your code goes here
	}
	
	@Test
	public void registerNewRestaurantInvalidTest1() throws Exception{
		
		//Your code goes here
	}
	@Test
	public void registerNewRestaurantInvalidTest2() throws Exception{
		
		//Your code goes here
	}
	@Test
	public void addDishValidTest() throws Exception{
		
		//Your code goes here
		
	}
	
	
	@Test
	public void addDishInvalidTest1() throws Exception{
		
		//Your code goes here
		
	}
	
	@Test
	public void addDishInvalidTest2() throws Exception{
		
		//Your code goes here	
	}

	@Test
	public void updateDishValidTest() throws Exception{
		
		//Your code goes here
		
		
	}
	
	@Test
	public void updateDishInvalidTest1() throws Exception{
		
		//Your code goes here
	}
	
	@Test
	public void updateDishInvalidTest2() throws Exception{
		
		//Your code goes here
		
	}
	
	@Test
	public void deleteDishValidTest() throws Exception{
		
		//Your code goes here

	}
	
	@Test
	public void deleteDishInvalidTest1() throws Exception{
		
		//Your code goes here

	}
	
	@Test
	public void deleteDishInvalidTest2() throws Exception{
		
		//Your code goes here
	}
	
	@Test
	public void viewDishesValidTest() throws Exception{
		//Your code goes here
		
	}
	
	@Test
	public void viewDishesInvalidTest1() throws Exception{
		
		//Your code goes here
	}
	
	@Test
	public void viewDishesInvalidTest2() throws Exception{
		
		//Your code goes here
	}
	
	@Test
	public void viewRestaurantsValidTest() throws Exception{
		
		//Your code goes here
	}
	
	@Test
	public void viewRestaurantsInvalidTest1() throws Exception{
		
		//Your code goes here
	}
	
	@Test
	public void viewRestaurantsInvalidTest2() throws Exception{
		
		//Your code goes here
	}
}
