package com.infy.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Wallet;

public interface WalletRepository extends CrudRepository<Wallet, Integer> {

}
