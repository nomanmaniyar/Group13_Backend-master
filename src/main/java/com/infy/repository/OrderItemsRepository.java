package com.infy.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.OrderItems;

public interface OrderItemsRepository extends CrudRepository<OrderItems, Integer> {

}
