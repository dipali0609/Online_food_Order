package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.dao.Contactus;
import com.food.service.ContactusService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class ContactusController 
{
	@Autowired
   private  ContactusService contactusService;
   
	@PostMapping("/saveContact")
	public String saveContact(@RequestBody Contactus contactus)
	{
		 contactusService.saveContact(contactus);
		return "Send SuccessFully";
	}
   
	@GetMapping("/retriveddata")
	public List<Contactus> retrivedAllData()
	{
		return contactusService. retrivedAllData();
		
	}
}
