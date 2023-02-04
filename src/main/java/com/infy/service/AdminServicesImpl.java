package com.infy.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.DishDTO;
import com.infy.dto.RestaurantDTO;
import com.infy.dto.RestaurantTransactionDTO;
import com.infy.entity.Dish;
import com.infy.entity.Restaurant;
import com.infy.exception.FoodAddaException;
import com.infy.repository.RestaurantRepository;

@Service(value = "adminService")
@Transactional
public class AdminServicesImpl implements  AdminServices{

	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public String deleteRestaurant(Integer restaurantID) throws FoodAddaException {
	
		Optional<Restaurant> optional = restaurantRepository.findById(restaurantID);
		Restaurant restaurant = optional.orElseThrow(()->new FoodAddaException("AdminServices.RESTAURANT_DOES_NOT_EXIST"));
		restaurant.setApprovalStatus("Rejected");	
		return restaurant.getRestaurantName();
	}
	
	@Override
	public String grantPermissionToRestaurant(String status, RestaurantDTO restaurant) throws FoodAddaException {
		
		
		Optional<Restaurant> optional = restaurantRepository.findById(restaurant.getRestaurantId());
		Restaurant restaurantEntity = optional.orElseThrow(()->new FoodAddaException("AdminServices.RESTAURANT_DOES_NOT_EXIST"));
		
		restaurantEntity.setRestaurantId(restaurant.getRestaurantId());
		restaurantEntity.setRestaurantName(restaurant.getRestaurantName());
		restaurantEntity.setRestaurantType(restaurant.getRestaurantType());
		restaurantEntity.setRestaurantContact(restaurant.getRestaurantContact());
		restaurantEntity.setAddressLine1(restaurant.getAddressLine1());
		restaurantEntity.setArea(restaurant.getArea());
		restaurantEntity.setCity(restaurant.getCity());
		restaurantEntity.setResState(restaurant.getResState());
		restaurantEntity.setAvgRating(1.0);
		restaurantEntity.setPincode(restaurant.getPincode());
		restaurantEntity.setApprovalStatus(status);
		restaurantEntity.setDishes(null);
		
		return restaurantEntity.getApprovalStatus();
	}
	
	@Override
	public List<RestaurantDTO> getRestaurant() throws FoodAddaException{
		
		Iterable<Restaurant> restaurants = restaurantRepository.findAll();
		List<RestaurantDTO> list1 = new ArrayList<>();
		if (restaurants != null) {
			for (Restaurant re : restaurants) {
				RestaurantDTO r = new RestaurantDTO();
				r.setRestaurantId(re.getRestaurantId());
				r.setRestaurantName(re.getRestaurantName());
				r.setRestaurantContact(re.getRestaurantContact());
				r.setRestaurantType(re.getRestaurantType());
				r.setAddressLine1(re.getAddressLine1());
				r.setArea(re.getArea());
				r.setCity(re.getCity());
				r.setResState(re.getResState());
				r.setPincode(re.getPincode());
				r.setApprovalStatus(re.getApprovalStatus());
				r.setAvgRating(re.getAvgRating());
				String[] photos=re.getPhotoUrls().split("-");
				r.setPhotoUrls(Arrays.asList(photos));
				if(!re.getDishes().isEmpty()) {
					List<DishDTO> dishList=new ArrayList<>();
					for(Dish de:re.getDishes()) {
						DishDTO d=new DishDTO();
						d.setDishId(de.getDishId());
						d.setDishName(de.getDishName());
						d.setDishType(de.getDishType());
						d.setDishCuisine(de.getDishCuisine());
						d.setDishDescription(de.getDishDescription());
						d.setAvgRating(de.getAvgRating());
						d.setPrice(de.getPrice());
						d.setSpeciality(de.getSpeciality());
						d.setImageUrl(de.getImageUrl());
						dishList.add(d);
					}
					r.setDishes(dishList);
				}
				if(re.getTransaction()!=null) {
					RestaurantTransactionDTO rt=new RestaurantTransactionDTO();
					rt.setRestaurantTransactionId(re.getTransaction().getRestaurantTransactionId());
					rt.setRestaurantStatus(re.getTransaction().getRestaurantStatus());
					rt.setRestaurantApproxCost(re.getTransaction().getRestaurantApproxCost());
					rt.setRestaurantOrderCounter(re.getTransaction().getRestaurantOrderCounter());
					r.setTransaction(rt);
				}
				list1.add(r);
			}
		}
		List<RestaurantDTO> acceptedRestaurants = list1.stream().filter(restaurant -> restaurant.getApprovalStatus().equals("Accepted")).
				collect(Collectors.toList());
		
		if(acceptedRestaurants.isEmpty()) {
			
			throw new FoodAddaException("AdminService.NO_RESTAURANTS_FOUND");
		}
		return acceptedRestaurants;
	}
	
	@Override
	public List<RestaurantDTO> filterRestaurantOnRatings(Float ratings) throws FoodAddaException{
		
		Iterable<Restaurant> restaurants = restaurantRepository.findAll();
		List<RestaurantDTO> list1 = new ArrayList<>();
		if (restaurants != null) {
			for (Restaurant re : restaurants) {
				RestaurantDTO r = new RestaurantDTO();
				r.setRestaurantId(re.getRestaurantId());
				r.setRestaurantName(re.getRestaurantName());
				r.setRestaurantContact(re.getRestaurantContact());
				r.setRestaurantType(re.getRestaurantType());
				r.setAddressLine1(re.getAddressLine1());
				r.setArea(re.getArea());
				r.setCity(re.getCity());
				r.setResState(re.getResState());
				r.setPincode(re.getPincode());
				r.setApprovalStatus(re.getApprovalStatus());
				r.setAvgRating(re.getAvgRating());
				String[] photos=re.getPhotoUrls().split("-");
				r.setPhotoUrls(Arrays.asList(photos));
				if(!re.getDishes().isEmpty()) {
					List<DishDTO> dishList=new ArrayList<>();
					for(Dish de:re.getDishes()) {
						DishDTO d=new DishDTO();
						d.setDishId(de.getDishId());
						d.setDishName(de.getDishName());
						d.setDishType(de.getDishType());
						d.setDishCuisine(de.getDishCuisine());
						d.setDishDescription(de.getDishDescription());
						d.setAvgRating(de.getAvgRating());
						d.setPrice(de.getPrice());
						d.setSpeciality(de.getSpeciality());
						d.setImageUrl(de.getImageUrl());
						dishList.add(d);
					}
					r.setDishes(dishList);
				}
				if(re.getTransaction()!=null) {
					RestaurantTransactionDTO rt=new RestaurantTransactionDTO();
					rt.setRestaurantTransactionId(re.getTransaction().getRestaurantTransactionId());
					rt.setRestaurantStatus(re.getTransaction().getRestaurantStatus());
					rt.setRestaurantApproxCost(re.getTransaction().getRestaurantApproxCost());
					rt.setRestaurantOrderCounter(re.getTransaction().getRestaurantOrderCounter());
					r.setTransaction(rt);
				}
				list1.add(r);
			}
		}
		
		Double parsedRating = (double)ratings;
		List<RestaurantDTO> filteredRestaurant = new ArrayList<>();
		
		filteredRestaurant = list1.stream().filter(restaurant -> 
					restaurant.getAvgRating()<parsedRating &&  restaurant.getApprovalStatus().equals("Accepted"))
						.collect(Collectors.toList());
		
		if(filteredRestaurant.isEmpty()) throw new FoodAddaException("AdminService.NO_RESTAURANT_FOUND_UNDER_RATINGS");
		return filteredRestaurant;
	}
	
	@Override
	public List<RestaurantDTO> newlyAddedRstaurant() throws FoodAddaException{
		
		Iterable<Restaurant> restaurants = restaurantRepository.findAll();
		List<RestaurantDTO> list1 = new ArrayList<>();
		if (restaurants != null) {
			for (Restaurant re : restaurants) {
				RestaurantDTO r = new RestaurantDTO();
				r.setRestaurantId(re.getRestaurantId());
				r.setRestaurantName(re.getRestaurantName());
				r.setRestaurantContact(re.getRestaurantContact());
				r.setRestaurantType(re.getRestaurantType());
				r.setAddressLine1(re.getAddressLine1());
				r.setArea(re.getArea());
				r.setCity(re.getCity());
				r.setResState(re.getResState());
				r.setPincode(re.getPincode());
				r.setApprovalStatus(re.getApprovalStatus());
				r.setAvgRating(re.getAvgRating());
				String[] photos=re.getPhotoUrls().split("-");
				r.setPhotoUrls(Arrays.asList(photos));
				if(!re.getDishes().isEmpty()) {
					List<DishDTO> dishList=new ArrayList<>();
					for(Dish de:re.getDishes()) {
						DishDTO d=new DishDTO();
						d.setDishId(de.getDishId());
						d.setDishName(de.getDishName());
						d.setDishType(de.getDishType());
						d.setDishCuisine(de.getDishCuisine());
						d.setDishDescription(de.getDishDescription());
						d.setAvgRating(de.getAvgRating());
						d.setPrice(de.getPrice());
						d.setSpeciality(de.getSpeciality());
						d.setImageUrl(de.getImageUrl());
						dishList.add(d);
					}
					r.setDishes(dishList);
				}
				if(re.getTransaction()!=null) {
					RestaurantTransactionDTO rt=new RestaurantTransactionDTO();
					rt.setRestaurantTransactionId(re.getTransaction().getRestaurantTransactionId());
					rt.setRestaurantStatus(re.getTransaction().getRestaurantStatus());
					rt.setRestaurantApproxCost(re.getTransaction().getRestaurantApproxCost());
					rt.setRestaurantOrderCounter(re.getTransaction().getRestaurantOrderCounter());
					r.setTransaction(rt);
				}
				list1.add(r);
			}
		}
		 List<RestaurantDTO> newRestaurants = new ArrayList<>();
		 
		 newRestaurants = list1.stream().filter(restaurant -> 
		 	restaurant.getApprovalStatus().equals("Pending"))
				 .collect(Collectors.toList());
		 if(newRestaurants.isEmpty()) throw new FoodAddaException("AdminService.NO_NEW_RESTAURANT");
		 
		 return newRestaurants;
				 
	}
}
