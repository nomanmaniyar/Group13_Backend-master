package com.infy.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.UserAddressDTO;
import com.infy.dto.UsersDTO;
import com.infy.service.RestaurantRecommendationService;
import com.infy.service.UserService;

@RestController
@RequestMapping(value = "/foodadda")
public class UserAPI {

	@Autowired
	private UserService userService;
	@Autowired
	private Environment environment;
	@Autowired
	private RestaurantRecommendationService recommendationService;

	@PostMapping(value = "/register")
	public ResponseEntity<String> registerUser(@RequestBody @Valid UsersDTO user) throws Exception {

		// Your code goes here
		String username = userService.registerNewUser(user);

		return new ResponseEntity<>(environment.getProperty("UserAPI.REGISTER_USER_SUCCESS1") + username
				+ environment.getProperty("UserAPI.REGISTER_USER_SUCCESS2"), HttpStatus.CREATED);

	}

	public ResponseEntity<UsersDTO> authenticateUser(UsersDTO user) throws Exception {

		// Your code goes here
		return null;
	}

	public ResponseEntity<Integer> addAddress(UserAddressDTO address, Integer userId) throws Exception {

		// Your code goes here
		return null;
	}

	public ResponseEntity<String> updateAddress(UserAddressDTO address, Integer userId) throws Exception {

		// Your code goes here
		return null;

	}

	public ResponseEntity<String> deleteAddress(Integer addressId, Integer userId) throws Exception {

		// Your code goes here
		return null;

	}

	public ResponseEntity<UsersDTO> getAddressList(Integer userId) throws Exception {

		// Your code goes here
		return null;
	}

}
