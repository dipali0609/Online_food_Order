package com.food.service;

import java.util.List;

import com.food.dao.AddCart;

public interface AddCartService {

	public AddCart saveItemCart(AddCart addCart);

	public List<AddCart> addcart();

	public List<AddCart> deleteById(Integer itemid);

	public float generateBill();

}
