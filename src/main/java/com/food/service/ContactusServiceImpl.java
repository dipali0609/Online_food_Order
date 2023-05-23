package com.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.Contactus;
import com.food.repository.ContactusRepository;

@Service
public class ContactusServiceImpl implements ContactusService
{
	@Autowired
	private ContactusRepository contactusRepository;

	
	@Override
	public void saveContact(Contactus contactus) 
	{
		contactusRepository.save(contactus);
	}


	@Override
	public List<Contactus> retrivedAllData() {
		// TODO Auto-generated method stub
		return contactusRepository.findAll();
	}

}
