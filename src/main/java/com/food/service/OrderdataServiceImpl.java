package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.Orderdata;
import com.food.repository.OrderdataRepository;

@Service
public class OrderdataServiceImpl implements OrderdataService
{

	@Autowired
	private OrderdataRepository orderdataRepository;
	@Override
	public Integer savedata() {
		// TODO Auto-generated method stub
		return orderdataRepository.savedata();
	}

}
