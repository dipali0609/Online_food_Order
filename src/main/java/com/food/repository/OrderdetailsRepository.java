package com.food.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.food.dao.Item;
import com.food.dao.Orderdetails;

@Repository
public interface OrderdetailsRepository extends JpaRepository<Orderdetails, Integer>
{

	
//    @Query(value=" select item_id,cost,item_name,quantity from customer c,foodcart f, item i where c.customerid=f.customerid AND i.cartid=f.cartid AND c.customerid=?1",nativeQuery = true)
//	List<Item> viewAllOrders(Integer customerid);
//    @Query(value="select item_id,cost,item_name,quantity,order_id,order_date,order_status,bill_id from orderdetails o, customer c,foodcart f, item i where c.customerid=f.customerid AND i.cartid=f.cartid AND o.cartid=f.cartid AND c.customerid=?1", nativeQuery = true)
//    List<Orderdetails> viewAllOrders(Integer customerid);
    
    @Query(value="select * from orderdetails o, customer c,foodcart f, item i where c.customerid=f.customerid AND i.cartid=f.cartid AND o.cartid=f.cartid AND c.customerid=?1", nativeQuery = true)
    List<Orderdetails> viewAllOrders(Integer customerid);
    
    
    
}
