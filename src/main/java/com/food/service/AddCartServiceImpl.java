package com.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.AddCart;
import com.food.repository.AddCartRepository;

@Service
public class AddCartServiceImpl implements AddCartService
{

	@Autowired
	private AddCartRepository addCartRepository;
	@Override
	public AddCart saveItemCart(AddCart addCart) {
		// TODO Auto-generated method stub
		return addCartRepository.save(addCart);
	}
	@Override
	public List<AddCart> addcart() {
		// TODO Auto-generated method stub
		return addCartRepository.findAll();
	}
	

	@Override
	public List<AddCart> deleteById(Integer itemid) {
		// TODO Auto-generated method stub
		addCartRepository.deleteById(itemid);
		return addCartRepository.findAll();
	}
	@Override
	public float generateBill() {
		// TODO Auto-generated method stub
		
		return addCartRepository.generateBill();
	}
	
}
