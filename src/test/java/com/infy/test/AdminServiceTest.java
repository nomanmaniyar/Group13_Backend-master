package com.infy.test;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.dto.RestaurantDTO;
import com.infy.entity.Dish;
import com.infy.entity.Restaurant;
import com.infy.entity.RestaurantTransaction;
import com.infy.exception.FoodAddaException;
import com.infy.repository.RestaurantRepository;
import com.infy.service.AdminServices;
import com.infy.service.AdminServicesImpl;

@SpringBootTest
public class AdminServiceTest {
	
	@Mock
	private RestaurantRepository restaurantRepository;
	
	@InjectMocks
	private AdminServices adminServices = new AdminServicesImpl();


	@Test
	public void invalidDeleteRestaurantTest() throws Exception{
		Mockito.when(restaurantRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		FoodAddaException e = Assertions.assertThrows(FoodAddaException.class,()-> adminServices.deleteRestaurant(1));
		Assertions.assertEquals("AdminServices.RESTAURANT_DOES_NOT_EXIST", e.getMessage());
	}
	
	@Test
	public void validDeleteRestaurantTest() throws Exception{
		Restaurant restaurant = new Restaurant();
		restaurant.setRestaurantId(1);
		Mockito.when(restaurantRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(restaurant));
		Assertions.assertDoesNotThrow(()-> adminServices.deleteRestaurant(1));
	}
	
	@Test
	public void invalidGrantPermissionToRestaurantTest() throws Exception{
		RestaurantDTO restaurant = new RestaurantDTO();
		restaurant.setRestaurantId(1);
		Mockito.when(restaurantRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		FoodAddaException e = Assertions.assertThrows(FoodAddaException.class,()-> adminServices.grantPermissionToRestaurant("Accepted",restaurant));
		Assertions.assertEquals("AdminServices.RESTAURANT_DOES_NOT_EXIST", e.getMessage());
	}

	@Test
	public void invalidFilterRestaurantOnRatingsTest() throws Exception{
		Mockito.when(restaurantRepository.findAll()).thenReturn(new ArrayList<Restaurant>());
		FoodAddaException e = Assertions.assertThrows(FoodAddaException.class,
				()-> adminServices.filterRestaurantOnRatings((float)1));
		Assertions.assertEquals("AdminService.NO_RESTAURANT_FOUND_UNDER_RATINGS", e.getMessage());
		
	}
	
	@Test
	public void invalidGetRestaurantTest() throws Exception
	{
		Mockito.when(restaurantRepository.findAll()).thenReturn(new ArrayList<Restaurant>());
		FoodAddaException e = Assertions.assertThrows(FoodAddaException.class,
				()-> adminServices.getRestaurant());
		Assertions.assertEquals("AdminService.NO_RESTAURANTS_FOUND", e.getMessage());
		
	}
	
	
	
	@Test
	public void invalidNewlyAddedRstaurantTest() throws Exception{
		Mockito.when(restaurantRepository.findAll()).thenReturn(new ArrayList<Restaurant>());
		FoodAddaException e = Assertions.assertThrows(FoodAddaException.class,
				()-> adminServices.newlyAddedRstaurant());
		Assertions.assertEquals("AdminService.NO_NEW_RESTAURANT", e.getMessage());
	}
	
	
	@Test
	public void grantPermissionToRestaurantTest() throws Exception{
		Restaurant restaurant = new Restaurant();
		RestaurantDTO expected = new RestaurantDTO();
		restaurant.setRestaurantId(1);
		expected.setRestaurantType("Nonveg");
		expected.setRestaurantName("KFC");
		expected.setRestaurantId(1);
		expected.setRestaurantContact("9823414141");
		expected.setResState("Maharashtra");
		expected.setPincode(411041);
		expected.setCity("Pune");
		expected.setAddressLine1("23, Shastri Nagar");
		expected.setAvgRating(4.5);
		expected.setArea("Baner");
		expected.setApprovalStatus("Accepted");
		
		Mockito.when(restaurantRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(restaurant));
		Assertions.assertDoesNotThrow(()-> adminServices.grantPermissionToRestaurant("Accepted",expected));

	}

	@Test
	public void validGetRestaurantTest() throws Exception{
		List<Restaurant> restaurants = new ArrayList<>();
		Restaurant expected = new Restaurant();
		RestaurantTransaction t=new RestaurantTransaction();
		 List<Dish> dishList=new ArrayList<>();
		 Dish d1=new Dish();
		 d1.setAvgRating(4.5);
		 d1.setDishCuisine("Burger");
		 d1.setDishDescription("Spicy and chrunchy chicken tikki in soft bun with fresh lettuce and mustard sauce");
		 d1.setDishId(1001);
		 d1.setDishName("Chicken Burger");
		 d1.setDishType("Nonveg");
		 d1.setImageUrl("assets/chicken_burger.jpg");
		 d1.setPrice(150.0);
		 d1.setSpeciality("Chef Special");
		 dishList.add(d1);
		 Dish d2=new Dish();
		 d2.setAvgRating(4.2);
		 d2.setDishCuisine("Burger");
		 d2.setDishDescription("Spicy and chrunchy chicken tikki with soft bun with fresh lettuce and extra cheese");
		 d2.setDishId(1002);
		 d2.setDishName("Chicken Cheese Burger");
		 d2.setDishType("Nonveg");
		 d2.setImageUrl("assets/chicken_cheese_burger.jpg");
		 d2.setPrice(200.0);
		 d2.setSpeciality("Chef Special");
		 dishList.add(d2);
		 Dish d3=new Dish();
		 d3.setAvgRating(4.6);
		 d3.setDishCuisine("chicken");
		 d3.setDishDescription("Spicy and chrunchy chicken wings");
		 d3.setDishId(1003);
		 d3.setDishName("Chicken Wings");
		 d3.setDishType("Nonveg");
		 d3.setImageUrl("assets/chicken_wings.jpg");
		 d3.setPrice(550.0);
		 d3.setSpeciality("Chef Special");
		 dishList.add(d3);
		 Dish d4=new Dish();
		 d4.setAvgRating(4.5);
		 d4.setDishCuisine("Fries");
		 d4.setDishDescription("Classic crunchy and tasty french fries");
		 d4.setDishId(1012);
		 d4.setDishName("French Fries");
		 d4.setDishType("Veg");
		 d4.setImageUrl("assets/french_fries.jpg");
		 d4.setPrice(200.0);
		 d4.setSpeciality("Chef Special");
		 dishList.add(d4);
		 t.setRestaurantApproxCost(500);
		 t.setRestaurantOrderCounter(2);
		 t.setRestaurantStatus(true);
		 t.setRestaurantTransactionId(1);
		 expected.setRestaurantType("Nonveg");
		 expected.setRestaurantName("KFC");
		 expected.setRestaurantId(1);
		 expected.setRestaurantContact("9823414141");
		 expected.setResState("Maharashtra");
		 expected.setPincode(411041);
		 expected.setCity("Pune");
		 expected.setAddressLine1("23, Shastri Nagar");
		 expected.setAvgRating(4.5);
		 expected.setArea("Baner");
		 expected.setApprovalStatus("Accepted");
		 expected.setPhotoUrls("assets/kfca1.jpg");
		 expected.setDishes(dishList);
		 expected.setTransaction(t);
		 restaurants.add(expected);
		 Iterable<Restaurant> restaurantsList = restaurants;
		 Mockito.when(restaurantRepository.findAll()).thenReturn(restaurantsList);
         Assertions.assertDoesNotThrow(()-> adminServices.getRestaurant());
	}
	
	
	
	@Test
	public void validFilterRestaurantOnRatingsTest() throws Exception{
		List<Restaurant> restaurants = new ArrayList<>();
		Restaurant expected = new Restaurant();
		RestaurantTransaction t=new RestaurantTransaction();
		 List<Dish> dishList=new ArrayList<>();
		 Dish d1=new Dish();
		 d1.setAvgRating(4.5);
		 d1.setDishCuisine("Burger");
		 d1.setDishDescription("Spicy and chrunchy chicken tikki in soft bun with fresh lettuce and mustard sauce");
		 d1.setDishId(1001);
		 d1.setDishName("Chicken Burger");
		 d1.setDishType("Nonveg");
		 d1.setImageUrl("assets/chicken_burger.jpg");
		 d1.setPrice(150.0);
		 d1.setSpeciality("Chef Special");
		 dishList.add(d1);
		 Dish d2=new Dish();
		 d2.setAvgRating(4.2);
		 d2.setDishCuisine("Burger");
		 d2.setDishDescription("Spicy and chrunchy chicken tikki with soft bun with fresh lettuce and extra cheese");
		 d2.setDishId(1002);
		 d2.setDishName("Chicken Cheese Burger");
		 d2.setDishType("Nonveg");
		 d2.setImageUrl("assets/chicken_cheese_burger.jpg");
		 d2.setPrice(200.0);
		 d2.setSpeciality("Chef Special");
		 dishList.add(d2);
		 Dish d3=new Dish();
		 d3.setAvgRating(4.6);
		 d3.setDishCuisine("chicken");
		 d3.setDishDescription("Spicy and chrunchy chicken wings");
		 d3.setDishId(1003);
		 d3.setDishName("Chicken Wings");
		 d3.setDishType("Nonveg");
		 d3.setImageUrl("assets/chicken_wings.jpg");
		 d3.setPrice(550.0);
		 d3.setSpeciality("Chef Special");
		 dishList.add(d3);
		 Dish d4=new Dish();
		 d4.setAvgRating(4.5);
		 d4.setDishCuisine("Fries");
		 d4.setDishDescription("Classic crunchy and tasty french fries");
		 d4.setDishId(1012);
		 d4.setDishName("French Fries");
		 d4.setDishType("Veg");
		 d4.setImageUrl("assets/french_fries.jpg");
		 d4.setPrice(200.0);
		 d4.setSpeciality("Chef Special");
		 dishList.add(d4);
		 t.setRestaurantApproxCost(500);
		 t.setRestaurantOrderCounter(2);
		 t.setRestaurantStatus(true);
		 t.setRestaurantTransactionId(1);
		 expected.setRestaurantType("Nonveg");
		 expected.setRestaurantName("KFC");
		 expected.setRestaurantId(1);
		 expected.setRestaurantContact("9823414141");
		 expected.setResState("Maharashtra");
		 expected.setPincode(411041);
		 expected.setCity("Pune");
		 expected.setAddressLine1("23, Shastri Nagar");
		 expected.setAvgRating(4.5);
		 expected.setArea("Baner");
		 expected.setApprovalStatus("Accepted");
		 expected.setPhotoUrls("assets/kfca1.jpg");
		 expected.setDishes(dishList);
		 expected.setTransaction(t);
		 restaurants.add(expected);
		 Iterable<Restaurant> restaurantsList = restaurants;
		 Mockito.when(restaurantRepository.findAll()).thenReturn(restaurantsList);
		 Assertions.assertDoesNotThrow(()-> adminServices.filterRestaurantOnRatings((float)5));
	}
	
	

	@Test
	public void validNewlyAddedRestaurantTest() throws Exception{
	
		List<Restaurant> restaurants = new ArrayList<>();
		Restaurant expected = new Restaurant();
		 List<Dish> dishList=new ArrayList<>();
		 Dish d1=new Dish();
		 d1.setAvgRating(4.5);
		 d1.setDishCuisine("Burger");
		 d1.setDishDescription("Spicy and chrunchy chicken tikki in soft bun with fresh lettuce and mustard sauce");
		 d1.setDishId(1001);
		 d1.setDishName("Chicken Burger");
		 d1.setDishType("Nonveg");
		 d1.setImageUrl("assets/chicken_burger.jpg");
		 d1.setPrice(150.0);
		 d1.setSpeciality("Chef Special");
		 dishList.add(d1);
		 Dish d2=new Dish();
		 d2.setAvgRating(4.2);
		 d2.setDishCuisine("Burger");
		 d2.setDishDescription("Spicy and chrunchy chicken tikki with soft bun with fresh lettuce and extra cheese");
		 d2.setDishId(1002);
		 d2.setDishName("Chicken Cheese Burger");
		 d2.setDishType("Nonveg");
		 d2.setImageUrl("assets/chicken_cheese_burger.jpg");
		 d2.setPrice(200.0);
		 d2.setSpeciality("Chef Special");
		 dishList.add(d2);
		 Dish d3=new Dish();
		 d3.setAvgRating(4.6);
		 d3.setDishCuisine("chicken");
		 d3.setDishDescription("Spicy and chrunchy chicken wings");
		 d3.setDishId(1003);
		 d3.setDishName("Chicken Wings");
		 d3.setDishType("Nonveg");
		 d3.setImageUrl("assets/chicken_wings.jpg");
		 d3.setPrice(550.0);
		 d3.setSpeciality("Chef Special");
		 dishList.add(d3);
		 Dish d4=new Dish();
		 d4.setAvgRating(4.5);
		 d4.setDishCuisine("Fries");
		 d4.setDishDescription("Classic crunchy and tasty french fries");
		 d4.setDishId(1012);
		 d4.setDishName("French Fries");
		 d4.setDishType("Veg");
		 d4.setImageUrl("assets/french_fries.jpg");
		 d4.setPrice(200.0);
		 d4.setSpeciality("Chef Special");
		 dishList.add(d4);
		 expected.setRestaurantType("Nonveg");
		 expected.setRestaurantName("KFC");
		 expected.setRestaurantId(8);
		 expected.setRestaurantContact("9823414141");
		 expected.setResState("Maharashtra");
		 expected.setPincode(411041);
		 expected.setCity("Pune");
		 expected.setAddressLine1("23, Madegowda Circle");
		 expected.setAvgRating(1.1);
		 expected.setArea("Baner");
		 expected.setApprovalStatus("Pending");
		 expected.setPhotoUrls("assets/kfca1.jpg");
		 expected.setDishes(dishList);
		 RestaurantTransaction t=new RestaurantTransaction();
		 t.setRestaurantApproxCost(500);
		 t.setRestaurantOrderCounter(2);
		 t.setRestaurantStatus(true);
		 t.setRestaurantTransactionId(1);
		 expected.setTransaction(t);
		 restaurants.add(expected);
		 Iterable<Restaurant> restaurantsList = restaurants;
		 Mockito.when(restaurantRepository.findAll()).thenReturn(restaurantsList);
		 Assertions.assertDoesNotThrow(()-> adminServices.newlyAddedRstaurant());
		 
	}
	

}
