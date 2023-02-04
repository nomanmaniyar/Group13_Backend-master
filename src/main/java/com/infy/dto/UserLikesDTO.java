package com.infy.dto;

public class UserLikesDTO {

	private Integer likeId;
	private String vegNonveg;
	private DishDTO dish;
	private RestaurantDTO restaurant;
	public Integer getLikeId() {
		return likeId;
	}
	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}
	public String getVegNonveg() {
		return vegNonveg;
	}
	public void setVegNonveg(String vegNonveg) {
		this.vegNonveg = vegNonveg;
	}
	
	public DishDTO getDish() {
		return dish;
	}
	public void setDish(DishDTO dish) {
		this.dish = dish;
	}
	public RestaurantDTO getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(RestaurantDTO restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
