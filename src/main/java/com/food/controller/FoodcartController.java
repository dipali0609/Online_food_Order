package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.dao.Foodcart;
import com.food.error.GlobalExceptionHandling;
import com.food.service.FoodcartService;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FoodcartController 
{
	@Autowired
    private FoodcartService foodcartService;
	
	@PostMapping("/addFoodCart")
	public Foodcart addFoodCart(@RequestBody Foodcart foodcart)
	{
		return foodcartService.addFoodCart(foodcart);	
	}
	
	@DeleteMapping("/removeFoodCart/{fid}")
	public String removeFoodCart(@PathVariable("fid") Integer cartid) throws GlobalExceptionHandling
	{
		foodcartService.removeFoodCart(cartid);
		return "FoodCart Deleted Successfully";
		
	}
	
	@GetMapping("/viewFoodCart/{fid}")
	public Foodcart viewFoodCart(@PathVariable("fid") Integer cartid) throws GlobalExceptionHandling
	{
		return foodcartService.viewFoodCart(cartid);
	}
	
	@PutMapping("/Cartid/{caid}/Customer/{cid}")
	public Foodcart assignCartToCustomer(@PathVariable("caid") Integer cartid,@PathVariable("cid")Integer customerid )
	{
		return foodcartService.assignCartToCustomer(cartid, customerid);
		
	}
	
	
	
	
}
