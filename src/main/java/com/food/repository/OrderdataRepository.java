package com.food.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.food.dao.Orderdata;

@Repository
public interface OrderdataRepository extends JpaRepository<Orderdata, Integer>
{   
	@Transactional
	@Modifying
	@Query(value = "insert into orderdata (cost,item_name,quantity) select cost, item_name, quantity from add_cart", nativeQuery = true)
	Integer savedata();

}
