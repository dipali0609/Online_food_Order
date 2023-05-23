package com.food.service;

import java.util.List;

import javax.validation.Valid;

import com.food.dao.Item;
import com.food.dao.Orderdetails;
import com.food.error.GlobalExceptionHandling;

public interface OrderdetailsService {

	public Orderdetails saveOrderdetails(@Valid Orderdetails orderdetails);

	public Orderdetails updateOrderdetails(Integer orderId, Orderdetails orderdetails) throws GlobalExceptionHandling;

	public void deleteOrder(Integer orderId) throws GlobalExceptionHandling;

	public Orderdetails viewOrder(Integer orderId) throws GlobalExceptionHandling;

	public List<Item> viewAllOrders(Integer customerid);

	public Orderdetails assignOrderdetailsToBill(Integer orderId, Integer billId);

	public Orderdetails assignOrderdetailsToFoodcart(Integer orderId, Integer cartid);

//	public List<Item> viewAllOrders(Integer customerid) throws GlobalExceptionHandling;

}
