package com.infy.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {

}
