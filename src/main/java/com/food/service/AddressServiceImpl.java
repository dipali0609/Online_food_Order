package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.Address;
import com.food.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService
{
    @Autowired
	private AddressRepository addressRepository;
	@Override
	public Address saveAddress(Address address) {
		// TODO Auto-generated method stub
		return addressRepository.save(address);
	}

}
