package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.dao.Payment;

@Repository
public interface PaymentReposity extends JpaRepository<Payment, Integer>{

}
