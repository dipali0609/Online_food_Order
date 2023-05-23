package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.dao.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>
{

}
