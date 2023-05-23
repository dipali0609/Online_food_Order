package com.food.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.Bill;
import com.food.dao.Customer;
import com.food.dao.Foodcart;
import com.food.dao.Item;
import com.food.dao.Orderdetails;
import com.food.error.GlobalExceptionHandling;
import com.food.repository.BillRepository;
import com.food.repository.CustomerRepository;
import com.food.repository.FoodcartRepository;
import com.food.repository.ItemRepository;
import com.food.repository.OrderdetailsRepository;

@Service
public class OrderdetailsServiceImpl implements OrderdetailsService
{
	@Autowired
	private OrderdetailsRepository orderdetailsRepository;
    @Autowired
	private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private BillRepository billRepository;
    
    @Autowired
    private FoodcartRepository foodcartRepository;
    
	@Override
	public Orderdetails saveOrderdetails(@Valid Orderdetails orderdetails) {
		// TODO Auto-generated method stub
		return orderdetailsRepository.save(orderdetails);
	}

	@Override
	public Orderdetails updateOrderdetails(Integer orderId, Orderdetails orderdetails) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Orderdetails> od=orderdetailsRepository.findById(orderId);
		if(!od.isPresent())
		{
			throw new GlobalExceptionHandling(orderId+" Is Not Present");
		}
		else
		{
			Orderdetails od1=orderdetailsRepository.findById(orderId).get();
			if(od1!=null)
			{
				od1.setOrderDate(orderdetails.getOrderDate());
				od1.setOrderStatus(orderdetails.getOrderStatus());
				return orderdetailsRepository.save(od1);
			}
			return od1;
		}
	}

	@Override
	public void deleteOrder(Integer orderId) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Orderdetails> od=orderdetailsRepository.findById(orderId);
		if(!od.isPresent())
		{
			throw new GlobalExceptionHandling(orderId+" Is Not Prsent");
		}
		else
		{
			orderdetailsRepository.deleteById(orderId);
		}
	}

	@Override
	public Orderdetails viewOrder(Integer orderId) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Orderdetails> od=orderdetailsRepository.findById(orderId);
		if(!od.isPresent())
		{
			throw new GlobalExceptionHandling(orderId+" Is Not Prsent");
		}
		else
		{
			return orderdetailsRepository.findById(orderId).get();
		}
	}

	
	@Override
	public Orderdetails assignOrderdetailsToBill(Integer orderId, Integer billId) {
		Orderdetails ord1=orderdetailsRepository.findById(orderId).get();
		Bill bill2=billRepository.findById(billId).get();
		ord1.assignOrderdetailsToBill(bill2);
		return orderdetailsRepository.save(ord1);	
	}
@Override
	public Orderdetails assignOrderdetailsToFoodcart(Integer orderId, Integer cartid) {
		Orderdetails ord1=orderdetailsRepository.findById(orderId).get();
		Foodcart fcart=foodcartRepository.findById(cartid).get();
		ord1.assignOrderdetailsToFoodcart(fcart);
		return orderdetailsRepository.save(ord1);	
	}
//	@Override
//	public List<Orderdetails> viewAllOrders(Integer customerid) {
//		// TODO Auto-generated method stub
//		return orderdetailsRepository.viewAllOrders(customerid);
//	}
	
	
	
	@Override
	public List<Item> viewAllOrders(Integer customerid) {
		// TODO Auto-generated method stub
		return itemRepository.viewAllOrders(customerid);
	}

//	@Override
//	public List<Item> viewAllOrders(Integer customerid) throws GlobalExceptionHandling {
//		// TODO Auto-generated method stub
//		Optional<Customer> cust=customerRepository.findById(customerid);
//		Optional<Orderdetails> od=orderdetailsRepository.findById(customerid);
//		if(!cust.isPresent())
//		{
//			throw new GlobalExceptionHandling(customerid+" Is Not Prsent");
//		}
//		else
//		{
//			Orderdetails orderdetails=od.get();
//			Customer customer = cust.get();
//			List<Item> itemList =orderdetails.getCart().getCustomer();
//			System.out.println(itemList);
//			return itemList;
//			
//	    }
//		
		
	//}
//}
}
