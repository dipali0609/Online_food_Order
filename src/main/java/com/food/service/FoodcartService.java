package com.food.service;

import com.food.dao.Foodcart;
import com.food.error.GlobalExceptionHandling;

public interface FoodcartService {

	public Foodcart addFoodCart(Foodcart foodcart);

	public void removeFoodCart(Integer cartid) throws GlobalExceptionHandling;

	public Foodcart viewFoodCart(Integer cartid) throws GlobalExceptionHandling;

	public Foodcart assignCartToCustomer(Integer cartid, Integer customerid);

}
