package com.food.service;
import java.util.List;

import com.food.dao.Customer;
import com.food.error.GlobalExceptionHandling;
public interface CustomerService {

	public Customer saveCustomer(Customer customer);

	public Customer updateCustomerById(Integer customerid, Customer customer) throws GlobalExceptionHandling;

	public Customer viewCustomerById(Integer customerid) throws GlobalExceptionHandling;

	public void deleteCustomerById(Integer customerid) throws GlobalExceptionHandling;

	public Customer assignCustomerToAddress(Integer customerid, Integer addressId);

	public List<Customer> retrivedAllData();

	public List<Customer> loginCheck(String customeremailid);

}
