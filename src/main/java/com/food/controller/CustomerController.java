package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.food.dao.Customer;
import com.food.error.GlobalExceptionHandling;


import com.food.service.CustomerService;


import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class CustomerController
{
 @Autowired
private CustomerService customerService;

@PostMapping("/CustomerRegistration")
public String  saveCustomer(@RequestBody Customer customer)
{
	customerService.saveCustomer(customer);
		return "Successfully Registered";
}

@PutMapping("/updateCustomerById/{cid}")
public Customer updateCustomerById(@PathVariable("cid") Integer customerid,@RequestBody Customer customer) throws GlobalExceptionHandling
{
	return customerService. updateCustomerById(customerid, customer);	
}

@GetMapping("/viewCustomerById/{cid}")
public Customer viewCustomerById(@PathVariable("cid") Integer customerid) throws GlobalExceptionHandling
{
	return customerService.viewCustomerById(customerid);
	
}
@DeleteMapping("/deleteCustomerById/{cid}")
public String deleteCustomerById(@PathVariable("cid") Integer customerid) throws GlobalExceptionHandling
{
	customerService.deleteCustomerById(customerid);
	return "Customer id Delete Succesfully";	
}
@PutMapping("/assigncustomer/{cid}/address/{aid}")
public Customer assignCustomerToAddress(@PathVariable("cid")Integer customerid, @PathVariable("aid")Integer addressId)
{
	return customerService.assignCustomerToAddress(customerid,addressId);
}
@GetMapping("/retrivedData")
public List<Customer> retrivedAllData()
{
	return customerService.retrivedAllData();
	
}

@GetMapping("/logincheck/{eid}")
public String loginCheck(@PathVariable("eid") String customeremailid)
{
	List<Customer> cust=customerService.loginCheck(customeremailid);
	if(!cust.isEmpty())
	{
		return "Loginsuccesfull";
	}
	else
	{
		return "Invalid";
	}
}
//@GetMapping("/loginDetails/{cid}")
//public Customer retriveloginDetails(@RequestBody Customer customer,@PathVariable("cid")Integer customerid)
//{
//	return customerService.retriveloginDetails(customer, customerid);
//	
//}

}
