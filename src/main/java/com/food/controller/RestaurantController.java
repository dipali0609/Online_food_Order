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

import com.food.dao.Restaurant;
import com.food.error.GlobalExceptionHandling;
import com.food.service.RestaurantService;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RestaurantController 
{
     @Autowired
	private RestaurantService restaurantService;
     
     @PostMapping("/addRestaurant")
     public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody Restaurant restaurant)
     {
    	 Restaurant res=restaurantService.addRestaurant(restaurant);
    	 return new ResponseEntity<Restaurant>(res, HttpStatus.CREATED);
     }
     
     @PutMapping("/updateRestaurant/{rid}")
     public Restaurant updateRestaurant(@PathVariable("rid") Integer restaurantId, @RequestBody Restaurant restaurant) throws GlobalExceptionHandling
     {
		return restaurantService.updateRestaurant(restaurantId,restaurant);
    	 
     }
     
     @DeleteMapping("/removeRestaurant/{rid}")
     public String removeRestaurant(@PathVariable("rid") Integer restaurantId ) throws GlobalExceptionHandling
     {
    	 restaurantService.removeRestaurant(restaurantId);
		return "Restaurant Deleted Successfully";	 
     }
     
     @GetMapping("/viewRestaurant/{rid}")
     public Restaurant viewRestaurant(@PathVariable("rid") Integer restaurantId) throws GlobalExceptionHandling
     {
    	 return restaurantService.viewRestaurant(restaurantId);
     }
     
     @PutMapping("/assignRestaurant/{rid}/address/{aid}")
	   public Restaurant assignRestaurantToAddress(@PathVariable("rid") Integer restaurantId, @PathVariable("aid") Integer addressid)
	   {
 		 return restaurantService.assignRestaurantToAddress(restaurantId,addressid);
	   }
}
