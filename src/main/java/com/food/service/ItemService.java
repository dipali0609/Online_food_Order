package com.food.service;

import java.util.List;

import javax.validation.Valid;

import com.food.dao.Item;
import com.food.error.GlobalExceptionHandling;

public interface ItemService {

	public Item saveItem(@Valid Item item);

	public Item updateItem(Integer itemId, Item item) throws GlobalExceptionHandling;

	public Item viewItemById(Integer itemId) throws GlobalExceptionHandling;

	public void removeItemById(Integer itemId) throws GlobalExceptionHandling;

	public List<Item> viewAllItem();

	public Item categoryaOfItem(Integer itemId, Integer categoryId);

	public Item itemAddToCart(Integer itemId, Integer cartid);

	public Item restaurentassignTocart(Integer itemId, Integer restaurantId);

	public List<Item> retriveAllItem();

	public List<Item> retriveAllNonItem();
	

}
