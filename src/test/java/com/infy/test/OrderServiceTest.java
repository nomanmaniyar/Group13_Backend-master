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

import com.infy.dto.DishDTO;
import com.infy.dto.OrderItemsDTO;
import com.infy.dto.OrdersDTO;
import com.infy.entity.Dish;
import com.infy.entity.OrderItems;
import com.infy.entity.Orders;
import com.infy.entity.Restaurant;
import com.infy.entity.RestaurantTransaction;
import com.infy.entity.Users;
import com.infy.exception.FoodAddaException;
import com.infy.repository.DishRepository;
import com.infy.repository.OrdersRepository;
import com.infy.repository.RestaurantRepository;
import com.infy.repository.UsersRepository;
import com.infy.service.OrderService;
import com.infy.service.OrderServiceImpl;

@SpringBootTest
public class OrderServiceTest {

	@Mock
	private UsersRepository userRepository;
	
	@Mock
	private DishRepository dishRepository;
	
	@Mock
	private OrdersRepository orderRepository;
	
	@Mock
	private RestaurantRepository restaurantRepository;
	
	@InjectMocks
	private OrderService orderService = new OrderServiceImpl();
	
	
	
	
	@Test
	public void invalidViewOrdersTest() throws Exception{
		Mockito.when(orderRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		FoodAddaException e = Assertions.assertThrows(FoodAddaException.class, ()-> orderService.viewOrders(1));
		Assertions.assertEquals("orderService.NO_USER_FOUND", e.getMessage());
	}
	

	


	
	@Test
	public void validviewOrders() throws Exception{
		
		Users u1 = new Users();
		
		List<Orders> orders = new ArrayList<>();
		Orders order = new Orders();
		OrderItems o1 = new OrderItems();
		List<OrderItems> dishList=new ArrayList<>();
		order.setOrderBill(750);
		order.setOrderId(1002);
		order.setOrderStatus("ACTIVE");
		Dish d1=new Dish();
		 d1.setAvgRating(4.5);
		 d1.setDishCuisine("Pizza");
		 d1.setDishDescription("Plain and classic cheese pizza");
		 d1.setDishId(1004);
		 d1.setDishName("Margarita Pizza");
		 d1.setDishType("Veg");
		 d1.setImageUrl("assets/margarita_pizza.jpg");
		 d1.setPrice(250.0);
		 d1.setSpeciality("Chef Special");
		 o1.setDish(d1);
		 o1.setOrderItemsId(2);
		 o1.setQty(3);
		 dishList.add(o1);
		 
		 order.setOrderItemsList(dishList);
		 orders.add(order);
		u1.setOrdersList(orders);
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(u1));
		
	Assertions.assertDoesNotThrow(()->orderService.viewOrders(105));
		
	}

	@Test
	public void invalidViewOrdersTest2() throws Exception{
		Users u1 = new Users();
		List<Orders> orders = new ArrayList<>();
		u1.setOrdersList(orders);
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(u1));
		FoodAddaException e = Assertions.assertThrows(FoodAddaException.class, ()-> orderService.viewOrders(1));
		Assertions.assertEquals("orderService.NO_ORDER_FOUND", e.getMessage());
	}
	
	@Test
	public void invalidPlaceAnOrderTest() throws Exception{
		OrdersDTO order = new OrdersDTO();
		order.setOrderId(1001);
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
	    FoodAddaException e = Assertions.assertThrows(FoodAddaException.class, ()-> orderService.placeAnOrder(1, order));
		Assertions.assertEquals("orderService.NO_USER_FOUND", e.getMessage());
	}
	@Test
	public void invalidPlaceAnOrderTest2() throws Exception{
		Users u1 = new Users();
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(u1));
	    FoodAddaException e = Assertions.assertThrows(FoodAddaException.class, ()-> orderService.placeAnOrder(1, null));
		Assertions.assertEquals("orderService.NO_ORDER_FOUND", e.getMessage());
	}
	
	@Test
	public void validPlaceAnOrderTest() throws Exception{
		OrdersDTO order = new OrdersDTO();
		order.setOrderBill(750);
		order.setOrderStatus("ACTIVE");
		List<OrderItemsDTO> dishList=new ArrayList<>();
		OrderItemsDTO o1 = new OrderItemsDTO();
		DishDTO d=new DishDTO();
		d.setDishId(1004);
		o1.setDish(d);
		o1.setOrderItemsId(2);
		o1.setQty(3);
		dishList.add(o1);
		order.setOrderItemsList(dishList);
		
		Users u1 = new Users();	
		List<Orders> orders = new ArrayList<>();
		u1.setOrdersList(orders);
		
		Dish d1 = new Dish();
		d1.setAvgRating(4.5);
		d1.setDishCuisine("Pizza");
		d1.setDishDescription("Plain and classic cheese pizza");
		d1.setDishId(1004);
		d1.setDishName("Margarita Pizza");
		d1.setDishType("Veg");
		d1.setImageUrl("assets/margarita_pizza.jpg");
		d1.setPrice(250.0);
		d1.setSpeciality("Chef Special");
		
		Orders orderEntity = new Orders();
		orderEntity.setOrderId(101);
		Mockito.when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(u1));
		Mockito.when(dishRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(d1));
		Mockito.when(orderRepository.save(Mockito.any())).thenReturn(orderEntity);
		Assertions.assertDoesNotThrow(()->orderService.placeAnOrder(1, order));
		
	}
	
	@Test
	public void validRestaurantNamesTest() throws Exception{
		
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
		Iterable<Restaurant> allRestaurants = restaurants;
		
		List<Integer> dishid = List.of(1012,1001,1002,1003);
		Mockito.when(restaurantRepository.findAll()).thenReturn(allRestaurants);
		Assertions.assertDoesNotThrow(()->orderService.restaurantNames(dishid));
	    
	}

}
	
	
	
	
	
	
	

