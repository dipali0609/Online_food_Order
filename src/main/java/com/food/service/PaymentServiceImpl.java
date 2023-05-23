package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.Payment;
import com.food.repository.PaymentReposity;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentReposity  paymentRepository;
	
	@Override
	public void savePayment(Payment payment) {
		 paymentRepository.save(payment);
	}

}
