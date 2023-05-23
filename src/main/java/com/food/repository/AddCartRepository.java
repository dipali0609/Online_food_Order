package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.food.dao.AddCart;

@Repository
public interface AddCartRepository extends JpaRepository<AddCart, Integer>
{
  @Query(value="select sum(quantity*cost) from add_cart", nativeQuery = true)
	float generateBill();

}
