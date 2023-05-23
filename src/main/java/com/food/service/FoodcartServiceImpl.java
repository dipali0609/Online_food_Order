package com.food.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.Customer;
import com.food.dao.Foodcart;
import com.food.error.GlobalExceptionHandling;
import com.food.repository.CustomerRepository;
import com.food.repository.FoodcartRepository;

@Service
public class FoodcartServiceImpl implements FoodcartService
{
    @Autowired
	private FoodcartRepository foodcartRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
	@Override
	public Foodcart addFoodCart(Foodcart foodcart) 
    {
		// TODO Auto-generated method stub
		return foodcartRepository.save(foodcart);
	}

	@Override
	public void removeFoodCart(Integer cartid) throws GlobalExceptionHandling 
	{
		Optional<Foodcart> fc=foodcartRepository.findById(cartid);
		if(!fc.isPresent())
		{
			throw new GlobalExceptionHandling(cartid+" Is Not Present");
		}
		else
		{
			foodcartRepository.deleteById(cartid);
		}
		
		
	}

	@Override
	public Foodcart viewFoodCart(Integer cartid) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Foodcart> fc=foodcartRepository.findById(cartid);
		if(!fc.isPresent())
		{
			throw new GlobalExceptionHandling(cartid+" Is Not Present");
		}
		else
		{
			return foodcartRepository.findById(cartid).get();
		}
	}

	@Override
	public Foodcart assignCartToCustomer(Integer cartid, Integer customerid) {
		// TODO Auto-generated method stub
		Foodcart foodc=foodcartRepository.findById(cartid).get();
	    Customer cus=customerRepository.findById(customerid).get();
	    foodc.assignCartToCustomer(cus);
		return foodcartRepository.save(foodc);
	}
	
	
	

}
