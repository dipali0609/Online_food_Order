package com.food.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.Address;
import com.food.dao.Customer;
import com.food.error.GlobalExceptionHandling;
import com.food.repository.AddressRepository;
import com.food.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
	private CustomerRepository customerRepository;
    
    @Autowired
    private AddressRepository addressRepository;
    
	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}
	@Override
	public Customer updateCustomerById(Integer customerid, Customer customer) throws GlobalExceptionHandling 
	{
		
		Optional<Customer> cust=customerRepository.findById(customerid);
		if(!cust.isPresent())
		{
			throw new GlobalExceptionHandling(customerid+" Customer Id Is Not Present");
		}
		else
		{
			Customer cust1= customerRepository.findById(customerid).get();
			if(cust!=null)
			{
			cust1.setCustomerfname(customer.getCustomerfname());
			cust1.setCustomerlname(customer.getCustomerlname());
			cust1.setCustomermobile(customer.getCustomermobile());
			cust1.setCustomeremailid(customer.getCustomeremailid());
			cust1.setCustomerpassword(customer.getCustomerpassword());
			return customerRepository.save(cust1);	
			}
			return cust1 ;	
		}
		
	}
	@Override
	public Customer viewCustomerById(Integer customerid) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		 Optional<Customer> cust=customerRepository.findById(customerid);
		 if(!cust.isPresent())
		 {
			throw new GlobalExceptionHandling(customerid+" Customer Id Is Not Present"); 
		 }
		 else
		 {
			Customer cust1=customerRepository.findById(customerid).get();
			 return cust1;
		 }
		
	}
	@Override
	public void deleteCustomerById(Integer customerid) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Customer> cust=customerRepository.findById(customerid);
		if(!cust.isPresent())
		{
			throw new GlobalExceptionHandling(customerid+" Customer Id Is Not Present"); 
		}
		else
		{
			customerRepository.deleteById(customerid);	 
		}
		
	}
	@Override
	public Customer assignCustomerToAddress(Integer customerid, Integer addressId) {
		// TODO Auto-generated method stub
	    Customer customer=customerRepository.findById(customerid).get();
	    Address address=addressRepository.findById(addressId).get();
	    customer.assignCustomerToAddress(address);
	    return customerRepository.save(customer);
	}
	@Override
	public List<Customer> retrivedAllData() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
	@Override
	public List<Customer> loginCheck(String customeremailid) {
		
	
	return customerRepository.loginCheck(customeremailid);	
		
	}
	}
	
	


