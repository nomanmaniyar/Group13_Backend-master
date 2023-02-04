package com.infy.service;

import java.util.List;

import com.infy.dto.OrdersDTO;

public interface OrderService {

	public List<OrdersDTO> viewOrders(Integer userId) throws Exception;
	
	public Integer placeAnOrder(Integer id, OrdersDTO order) throws Exception;

	public List<String> restaurantNames(List<Integer> dishid);
}
