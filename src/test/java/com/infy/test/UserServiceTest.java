package com.infy.test;


import org.junit.jupiter.api.Test;

import com.infy.repository.UserAddressRepository;
import com.infy.repository.UsersRepository;
import com.infy.service.UserService;
import com.infy.service.UserServiceImpl;



public class UserServiceTest {
	
	
	private UsersRepository userRepository;
	
	
	private UserAddressRepository userAddressRepository;
	
		
	private UserService userService = new UserServiceImpl();
	
	
	public void loginInvalidUserTest()throws Exception{

		//Your code goes here
		
	}
	
	@Test
	public void loginNullPasswordTest()throws Exception{
		
		//Your code goes here
		
	}
	
	@Test
	public void loginInvalidPasswordTest()throws Exception{
		
		//Your code goes here
		
	}
	
	@Test
	public void loginValidTest()throws Exception{
		
		//Your code goes here
		
	}
	
	@Test
	public void invalidRoleregisterNewUserTest() throws Exception{
		
		//Your code goes here
		
	}
	
	@Test
	public void invalidUserRegisterNewUserTest() throws Exception{
		
		//Your code goes here
		
	}

	@Test
	public void validRegisterNewUserTest() throws Exception{
		
		//Your code goes here

	}
	
	@Test
	public void invalidAddNewAddressTest() throws Exception {
		
		//Your code goes here
	}
	
	@Test
	public void validAddNewAddressTest() throws Exception {
		
		//Your code goes here
	}
	
	
	@Test
	public void invalidUpdateAddressInvalidTest() throws Exception{
		
		//Your code goes here
		
	}
	
	
	@Test
	public void validUpdateAddressTest() throws Exception{
		
		//Your code goes here
		
	}
	
	@Test
	public void validDeleteAddressTest() throws Exception{
		

		
	}
}
