package com.infy.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.RestaurantTransaction;

public interface RestaurantTransactionRepository extends CrudRepository<RestaurantTransaction, Integer> {

}
