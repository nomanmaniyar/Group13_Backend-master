package com.infy.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.UserAddress;

public interface UserAddressRepository extends CrudRepository<UserAddress, Integer> {

}
