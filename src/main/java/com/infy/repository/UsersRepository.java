package com.infy.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {

	Optional<Users> findByContactNumber(String contactNumber);// Add methods if required

}
