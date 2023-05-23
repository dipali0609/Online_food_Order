package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.dao.Foodcart;

@Repository
public interface FoodcartRepository extends JpaRepository<Foodcart, Integer> 
{

}
