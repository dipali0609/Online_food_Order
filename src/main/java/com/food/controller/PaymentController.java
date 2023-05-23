package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.dao.Customer;
import com.food.dao.Payment;
import com.food.service.PaymentService;

@CrossOrigin(origins = "http://localhost:4200") //connect with angular
@RestController
public class PaymentController {
	
	 
	  @Autowired
	  private PaymentService paymentService;
	  
	  @PostMapping("/savePayment")
	  public String savePayment(@RequestBody Payment payment) {
		     paymentService.savePayment(payment);	 
			return "Payment Successfully";
	
	  }
	 

}
