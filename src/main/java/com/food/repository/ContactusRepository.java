package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.dao.Contactus;

@Repository
public interface ContactusRepository extends JpaRepository<Contactus, Integer>
{

}
