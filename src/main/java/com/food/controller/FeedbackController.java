package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.dao.Feedback;
import com.food.service.FeedbackService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/saveFeedback")
	public String saveFeedback(@RequestBody Feedback feedback)
	{
		feedbackService.saveFeedback(feedback);
		return "SuccessFully Send";
		
	}
	
	@GetMapping("/retrivedAllData")
	public List<Feedback> retrivedAllData()
	{
		return feedbackService.retrivedAllData();
		
	}
}
