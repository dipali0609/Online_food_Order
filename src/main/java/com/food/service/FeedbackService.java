package com.food.service;

import java.util.List;

import com.food.dao.Feedback;

public interface FeedbackService {

	void saveFeedback(Feedback feedback);

	List<Feedback> retrivedAllData();

}
