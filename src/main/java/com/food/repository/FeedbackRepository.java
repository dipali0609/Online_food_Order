package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.dao.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer>
{

}
