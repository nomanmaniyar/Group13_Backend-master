package com.infy.service;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.Role;
import com.infy.dto.RolesDTO;
import com.infy.dto.UserAddressDTO;
import com.infy.dto.UsersDTO;
import com.infy.entity.Roles;
import com.infy.entity.Users;
import com.infy.exception.FoodAddaException;
import com.infy.repository.UserAddressRepository;
import com.infy.repository.UsersRepository;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private UserAddressRepository userAddressRepository;

	@Override
	public UsersDTO authenticateUser(String contactNumber, String password) throws Exception {

		// Your code goes here
		return null;
	}

	@Override
	public String registerNewUser(UsersDTO user) throws Exception {

		// Your code goes here

		Optional<Users> users = userRepository.findByContactNumber(user.getContactNumber());

		if (users.isPresent()) {
			for (Roles role : users.get().getRoles()) {
				for (RolesDTO role1 : user.getRoles()) {
					if (role.getRoleType().equals(role1.getRoleType())) {
						throw new FoodAddaException("UserService.USER_ALREADY_EXISTS");
					}
				}
			}
		}

		Users users2 = new Users();
		Roles roles = new Roles();
		for (RolesDTO role : user.getRoles()) {
			if (role.equals(Role.VENDOR)) {
				List<Roles> rolesList = new ArrayList<>();
				roles.setRoleId(role.getRoleId());
				roles.setRoleType(role.getRoleType());
				rolesList.add(roles);

				users2.setUserName(user.getUserName());
				users2.setEmailId(user.getEmailId());
				users2.setContactNumber(user.getContactNumber());
				users2.setPassword(user.getPassword());
				users2.setRoles(rolesList);
				users2 = userRepository.save(users2);
			}
		}
		return users2.getUserName();
	}

	@Override
	public Integer addNewAddress(UserAddressDTO address, Integer userId) throws Exception {

		// Your code goes here
		return null;
	}

	@Override
	public String updateAddress(UserAddressDTO address, Integer userId) throws Exception {

		// Your code goes here
		return null;
	}

	@Override
	public void deleteAddress(Integer addressId, Integer userId) throws Exception {

		// Your code goes here

	}
}
