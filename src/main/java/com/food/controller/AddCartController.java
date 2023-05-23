package com.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.dao.AddCart;
import com.food.service.AddCartService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AddCartController 
{
   @Autowired
   private AddCartService addCartService;
   
   @PostMapping("/saveItemCart")
   public AddCart saveItemCart(@RequestBody AddCart addCart)
   {
	return addCartService.saveItemCart(addCart);
	   
   }
   
   @GetMapping("/addToCart")
   public List<AddCart> addcart()
   {
	return addCartService.addcart() ;   
   }
   
   
   @GetMapping("/totalbill")
   public float generateBill()
   {
	return addCartService.generateBill();
	   
   }
   
   
   @DeleteMapping("/deletebyid/{id}")
   public List<AddCart> deleteById(@PathVariable("id") Integer itemid){
   	return addCartService.deleteById(itemid);
   }
}
