package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.dao.Orderdata;
import com.food.service.OrderdataService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class OrderdataController 
{
@Autowired
private OrderdataService orderdataService;

@PostMapping("/savedata")
public Integer savedata(@RequestBody Orderdata orderdata)
{
	return orderdataService.savedata();
	
}
}
