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

import com.infy.entity.Dish;
import com.infy.entity.Restaurant;
import com.infy.entity.RestaurantTransaction;
import com.infy.exception.FoodAddaException;
import com.infy.repository.RestaurantRepository;
import com.infy.service.SearchService;
import com.infy.service.SearchServiceImpl;

@SpringBootTest
public class SearchServiceTest {

	@Mock
	private RestaurantRepository restaurantRepository;
	
	@InjectMocks
	private SearchService searchService = new SearchServiceImpl();
	
	@Test
	public void invalidviewRestaurantDetails()throws Exception{
		Mockito.when(restaurantRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		FoodAddaException e = Assertions.assertThrows(FoodAddaException.class, ()-> searchService.viewRestaurantDetails(1));
		Assertions.assertEquals("SearchService.RESTAURANT_DOES_NOT_EXIST", e.getMessage());
	}
	
	@Test
	public void ViewAllRestaurantsInvalidTest()throws Exception{
		
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
		 expected.setApprovalStatus("Rejected");
		 expected.setPhotoUrls("assets/kfca1.jpg");
		 expected.setDishes(dishList);
		restaurants.add(expected);
		Iterable<Restaurant> restaurantsList = restaurants;
		Mockito.when(restaurantRepository.findAll()).thenReturn(restaurantsList);
		FoodAddaException e = Assertions.assertThrows(FoodAddaException.class, ()-> searchService.viewAllRestaurants());
		Assertions.assertEquals("SearchService.NO_RESTAURANTS_FOUND", e.getMessage());
	}
	
	@Test
	public void viewRestaurantDetailsValidTest()throws Exception{
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
		Mockito.when(restaurantRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(expected));
		Assertions.assertDoesNotThrow(()-> searchService.viewRestaurantDetails(1));
	}
	
	@Test
	public void viewAllRestaurantsValidTest()throws Exception{
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
		Assertions.assertDoesNotThrow(()-> searchService.viewAllRestaurants());
	}
}
