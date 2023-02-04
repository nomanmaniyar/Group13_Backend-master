package com.infy.repository;



import org.springframework.data.repository.CrudRepository;
import com.infy.entity.Dish;

public interface DishRepository extends CrudRepository<Dish, Integer>{
	
	//Add methods if required

}
