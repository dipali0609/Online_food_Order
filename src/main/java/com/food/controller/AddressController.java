package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.dao.Address;
import com.food.service.AddressService;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AddressController 
{
	@Autowired
   private AddressService addressService;
	
	@PostMapping("/saveAddress")
	public Address saveAddress(@RequestBody Address address)
	{
		return addressService.saveAddress(address);	
	}
	
}
