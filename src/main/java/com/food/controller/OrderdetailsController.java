package com.food.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.dao.Customer;
import com.food.dao.Item;
import com.food.dao.Orderdetails;
import com.food.error.GlobalExceptionHandling;
import com.food.repository.ItemRepository;
import com.food.service.OrderdetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrderdetailsController 
{
    @Autowired
	private OrderdetailsService orderdetailsService;
    
    
    @PostMapping("/saveOrderdetails")
    public ResponseEntity<Orderdetails> saveOrderdetails(@Valid @RequestBody Orderdetails orderdetails)
    {
    	Orderdetails od=orderdetailsService.saveOrderdetails(orderdetails);
    	return new ResponseEntity<Orderdetails>(od,HttpStatus.CREATED);
    }
    
    @PutMapping("/updateOrderdetails/{oid}")
    public Orderdetails updateOrderdetails(@PathVariable("oid") Integer orderId,@RequestBody Orderdetails orderdetails ) throws GlobalExceptionHandling
    {
		return orderdetailsService.updateOrderdetails(orderId,orderdetails);
    	
    }
    
    @DeleteMapping("/deleteOrder/{oid}")
    public String deleteOrder(@PathVariable("oid")Integer orderId ) throws GlobalExceptionHandling
    {
    	orderdetailsService.deleteOrder(orderId);
		return "Order Deleted Successfully";
    	
    }
    
    @GetMapping("/viewOrder/{oid}")
    public Orderdetails viewOrder(@PathVariable("oid")Integer orderId) throws GlobalExceptionHandling
    {
		return orderdetailsService.viewOrder(orderId);
    	
    }
    
    @PutMapping("/assignOrderdetails/{ordid}/Bill/{bid}")
	 public Orderdetails assignOrderdetailsToBill(@PathVariable("ordid") Integer orderId, @PathVariable("bid") Integer billId)
    {
		 return orderdetailsService.assignOrderdetailsToBill(orderId,billId);
    }
    
    @PutMapping("/assignOrderdetails/{ordid}/Foodcart/{fcid}")
	 public Orderdetails assignOrderdetailsToFoodcart(@PathVariable("ordid") Integer orderId, @PathVariable("fcid") Integer cartid)
   {
		 return orderdetailsService.assignOrderdetailsToFoodcart(orderId,cartid);
   }
    
    
    
    // select item_id,cost,item_name,quantity from customer c,foodcart f, item i where c.customerid=f.customerid AND i.cartid=f.cartid AND c.customerid=1;
    //select order_id, order_date,order_status,bill_id from customer c,foodcart f, orderdetails o where c.customerid=f.customerid AND o.order_id=f.cartid AND c.customerid=1;
   // select order_id, order_date,order_status,bill_id from customer c,foodcart f, orderdetails o where c.customerid=f.customerid AND o.order_id=f.cartid AND c.customerid=1;
    @GetMapping("/viewbycustomer/{cid}")
    public List<Item> viewAllOrders(@PathVariable("cid")Integer customerid ) throws GlobalExceptionHandling
    {
    	return orderdetailsService.viewAllOrders(customerid);
    }
   
    
    
    
    
}
