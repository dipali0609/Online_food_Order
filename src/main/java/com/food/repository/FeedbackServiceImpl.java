package com.food.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.Feedback;
import com.food.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService
{

	@Autowired
	private FeedbackRepository feedbackRepository;
	@Override
	public void saveFeedback(Feedback feedback)
	{
		feedbackRepository.save(feedback);
	}
	@Override
	public List<Feedback> retrivedAllData() {
		// TODO Auto-generated method stub
		return feedbackRepository.findAll();
	}

}
