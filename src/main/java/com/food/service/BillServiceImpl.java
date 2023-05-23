package com.food.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.Bill;
import com.food.dao.Customer;
import com.food.dao.Item;
import com.food.dao.Orderdetails;
import com.food.error.GlobalExceptionHandling;
import com.food.repository.BillRepository;
import com.food.repository.CustomerRepository;
import com.food.repository.OrderdetailsRepository;

@Service
public class BillServiceImpl implements BillService
{
    @Autowired
	private BillRepository billRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private OrderdetailsRepository orderdetailsRepository;
    
	@Override
	public Bill generateBill(@Valid Bill bill) {
		// TODO Auto-generated method stub
		return billRepository.save(bill);
	}
	
	@Override
	public Bill updateBillById(@Valid Integer billId, Bill bill) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Bill> b=billRepository.findById(billId);
		if(!b.isPresent())
		{
		  throw new GlobalExceptionHandling(billId+" Is Not Present");	
		}
		else
		{
			Bill b1=billRepository.findById(billId).get();
			if(b1!=null)
			{
				b1.setBillDate(bill.getBillDate());
				b1.setTotalCost(bill.getTotalCost());
				b1.setTotalItem(bill.getTotalItem());
				return billRepository.save(b1);
			}
			return b1;
		}
		
	}
	@Override
	public void removeBill(Integer billId) throws GlobalExceptionHandling 
	{
		// TODO Auto-generated method stub
		Optional<Bill> b=billRepository.findById(billId);
		if(!b.isPresent())
		{
			throw new GlobalExceptionHandling(billId+" Is Not Present");
		}
		else
		{
			billRepository.deleteById(billId);
		}
	}
	@Override
	public Bill viewBill(Integer billId) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Bill> b=billRepository.findById(billId);
		if(!b.isPresent())
		{
			throw new GlobalExceptionHandling(billId+" Is Not Present");
		}
		else
		{
			return billRepository.findById(billId).get();
			
		}
		
	}

	@Override
	public Bill assignBillToOrderdetails(Integer billid, Integer orderid) {
		// TODO Auto-generated method stub
		Bill b = billRepository.findById(billid).get();
		Orderdetails order2 = orderdetailsRepository.findById(orderid).get();
		
		b.assignBillToOrderdetails(order2);
	    return billRepository.save(b) ;
	}

	@Override
	public String TotalBill(Integer customerid) {
		// TODO Auto-generated method stub
		return billRepository.TotalBill(customerid);
	}
	
//	@Override
//	public Bill TotalBill(Integer customerid) {
//		// TODO Auto-generated method stub
//		Optional<Customer> cust=customerRepository.findById(customerid);
//		if(!cust.isPresent())
//		{
//			throw new GlobalExceptionHandling(customerid+" Is Not Present");
//		}
//		else
//		{
//			Customer cust1=cust.get();
//			
//		}
//		return null;
	
}
