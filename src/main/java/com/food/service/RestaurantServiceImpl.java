package com.food.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.Address;
import com.food.dao.Restaurant;
import com.food.error.GlobalExceptionHandling;
import com.food.repository.AddressRepository;
import com.food.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService
{
    @Autowired
	private RestaurantRepository restaurantRepository;
    
    @Autowired
    private AddressRepository addressRepository;
	@Override
	public Restaurant addRestaurant(@Valid Restaurant restaurant) {
		// TODO Auto-generated method stub
		return  restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Integer restaurantId, Restaurant restaurant) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Restaurant> res=restaurantRepository.findById(restaurantId);
		if(!res.isPresent())
		{
			throw new GlobalExceptionHandling(restaurantId+" Is Not Pressnt");
		}
		else
		{
			Restaurant res1=restaurantRepository.findById(restaurantId).get();
			if(res1!=null)
			{
				res1.setRestaurantName(restaurant.getRestaurantName());
				res1.setManagerName(restaurant.getManagerName());
				res1.setContactNumber(restaurant.getContactNumber());
				return restaurantRepository.save(res1);
			}
			return res1;
		}
		
	}

	@Override
	public void removeRestaurant(Integer restaurantId) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Restaurant> res=restaurantRepository.findById(restaurantId);
		if(!res.isPresent())
		{
			throw new GlobalExceptionHandling(restaurantId+" Is Not Pressnt");
		}
		else
		{
			 restaurantRepository.deleteById(restaurantId);
		}
	}

	@Override
	public Restaurant viewRestaurant(Integer restaurantId) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Restaurant> res=restaurantRepository.findById(restaurantId);
		if(!res.isPresent())
		{
			throw new GlobalExceptionHandling(restaurantId+" Is Not Pressnt");
		}
		else
		{
			return restaurantRepository.findById(restaurantId).get();
		}
	}
	
	
	@Override
	public Restaurant assignRestaurantToAddress(Integer restaurantId, Integer addressid) {
		Restaurant rest=restaurantRepository.findById(restaurantId).get();
		Address addr2=addressRepository.findById(addressid).get();
		rest.assignRestaurantToAddress(addr2);
		return restaurantRepository.save(rest);
	}

}
