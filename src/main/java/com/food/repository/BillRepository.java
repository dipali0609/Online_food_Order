package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.food.dao.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>
{

	@Query(value="select sum(total_cost) from bill b,orderdetails o, foodcart f , customer c where b.order_id=o.order_id AND o.cartid=f.cartid AND f.customerid=c.customerid AND c.customerid=?1", nativeQuery = true)
	String TotalBill(Integer customerid);

}
