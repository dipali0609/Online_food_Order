package com.food.service;

import javax.validation.Valid;

import com.food.dao.Restaurant;
import com.food.error.GlobalExceptionHandling;

public interface RestaurantService {

	public Restaurant addRestaurant(@Valid Restaurant restaurant);

	public Restaurant updateRestaurant(Integer restaurantId, Restaurant restaurant) throws GlobalExceptionHandling;

	public void removeRestaurant(Integer restaurantId) throws GlobalExceptionHandling;

	public Restaurant viewRestaurant(Integer restaurantId) throws GlobalExceptionHandling;

	public Restaurant assignRestaurantToAddress(Integer restaurantId, Integer addressid);

}
