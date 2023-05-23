package com.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.food.dao.Item;
import com.food.dao.Orderdetails;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>
{
	//@Query(value="select item_id,cost,item_name,quantity  from orderdetails o, customer c,foodcart f, item i where c.customerid=f.customerid AND i.cartid=f.cartid AND o.cartid=f.cartid AND c.customerid=?1", nativeQuery = true)
	//@Query(value=" select item_id,cost,item_name,quantity from customer c,foodcart f, item i where c.customerid=f.customerid AND i.cartid=f.cartid AND c.customerid=?1",nativeQuery = true)
	//List<Item> viewAllOrders(Integer customerid);
	//List<Orderdetails> viewAllOrders(Integer customerid);
	
	@Query(value="select * from orderdetails o, customer c,foodcart f, item i where c.customerid=f.customerid AND i.cartid=f.cartid AND o.cartid=f.cartid AND c.customerid=?1", nativeQuery = true)
	List<Item> viewAllOrders(Integer customerid);

	@Query(value="select * from item i , category c where i.category_id=c.category_id AND category_name='veg'", nativeQuery = true)
	List<Item> retriveAllItem();

	
	@Query(value="select * from item i , category c where i.category_id=c.category_id AND category_name='non-veg'", nativeQuery = true)
	List<Item> retriveAllNonItem();
}
