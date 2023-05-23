package com.food.service;

import javax.validation.Valid;

import com.food.dao.Bill;
import com.food.error.GlobalExceptionHandling;

public interface BillService {

	public Bill generateBill(@Valid Bill bill);

	public Bill updateBillById(@Valid Integer billId, Bill bill) throws GlobalExceptionHandling;

	public void removeBill(Integer billId) throws GlobalExceptionHandling;

	public Bill viewBill(Integer billId) throws GlobalExceptionHandling;

	public Bill assignBillToOrderdetails(Integer billid, Integer orderid);

	public String TotalBill(Integer customerid);

	//public Bill TotalBill(Integer customerid);

}
