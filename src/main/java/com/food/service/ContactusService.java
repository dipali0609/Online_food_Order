package com.food.service;

import java.util.List;

import com.food.dao.Contactus;

public interface ContactusService
{

	void saveContact(Contactus contactus);

	

	List<Contactus> retrivedAllData();

}
