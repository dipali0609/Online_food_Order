package com.food.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.dao.Bill;
import com.food.error.GlobalExceptionHandling;
import com.food.service.BillService;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BillController 
{
	@Autowired
  private BillService billService;
	
	@PostMapping("/addBill")
	public ResponseEntity<Bill> generateBill(@Valid @RequestBody Bill bill)
	{
		Bill bill1=billService.generateBill(bill);
		return new ResponseEntity<Bill>(bill1, HttpStatus.CREATED);	
	}
	
	@PutMapping("/updateBillById/{bid}")
	public ResponseEntity<Bill> updateBillById(@Valid @PathVariable("bid") Integer billId,@RequestBody Bill bill) throws GlobalExceptionHandling
	{
	     Bill bill1=billService.updateBillById(billId, bill);
		return new ResponseEntity<Bill>(bill1, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/removeBill/{bid}")
	public String removeBill(@PathVariable("bid") Integer billId) throws GlobalExceptionHandling
	{
		billService.removeBill(billId);
		return "Bill Deleted Successfully";	
	}
	
	@GetMapping("/viewBill/{bid}")
	public Bill viewBill(@PathVariable("bid") Integer billId) throws GlobalExceptionHandling
	{
		return billService.viewBill(billId);
		
	}
	@PutMapping("/assignBill/{bid}/orderdetails/{oid}")
	public Bill assignBillToOrderdetails(@PathVariable("bid") Integer billid, @PathVariable("oid") Integer orderid)
	{
		System.out.println("assignBillToOrderdetails");
		return billService.assignBillToOrderdetails(billid,orderid);
	}
	
	@GetMapping("/TotalBill/{cid}")
	public String TotalBill(@PathVariable("cid") Integer customerid)
	{
		return billService.TotalBill(customerid);
		
	}
}
