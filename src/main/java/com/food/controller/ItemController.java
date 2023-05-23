package com.food.controller;

import java.util.List;
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

import com.food.dao.Item;
import com.food.error.GlobalExceptionHandling;
import com.food.service.ItemService;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ItemController 
{
    @Autowired
	private ItemService itemService;
    
    @PostMapping("/saveItem")
    public ResponseEntity<Item> saveItem(@Valid @RequestBody Item item)
    {
    	Item it=itemService.saveItem(item);
		return new ResponseEntity<Item>(it, HttpStatus.CREATED);	
    }
    @PutMapping("/updateItem/{iid}")
    public Item updateItem(@PathVariable("iid") Integer itemId, @RequestBody Item item) throws GlobalExceptionHandling
    {
		return itemService.updateItem(itemId,item);
    	
    }
    @GetMapping("/viewItemById/{iid}")
    public Item viewItemById(@PathVariable("iid") Integer itemId) throws GlobalExceptionHandling
    {
		return itemService.viewItemById(itemId);
    	
    } 
    @DeleteMapping("/removeItemById/{iid}")
    public String removeItemById(@PathVariable("iid") Integer itemId) throws GlobalExceptionHandling
    {
		itemService.removeItemById(itemId);
		return "Id deleted Successfully";
    	
    }
    @GetMapping("/viewAllItem")
    public List<Item> viewAllItem()
    {
    	return itemService.viewAllItem();
    }
    
    @PutMapping("/item/{iid}/category/{cid}")
    public Item categoryaOfItem(@PathVariable("iid") Integer itemId, @PathVariable("cid") Integer categoryId)
    {
		return itemService.categoryaOfItem(itemId,categoryId);
    	
    }
    
    @PutMapping("/item/{iid}/cart/{caid}")
    public Item itemAddToCart(@PathVariable("iid") Integer itemId, @PathVariable("caid") Integer cartid)
    {
		return itemService.itemAddToCart(itemId,cartid);
    	
    }
    
    @PutMapping("/item/{iid}/restaurent/{rid}")
    public Item restaurentassignTocart( @PathVariable("iid") Integer itemId, @PathVariable("rid") Integer restaurantId)
    {
		return itemService.restaurentassignTocart(itemId,restaurantId);
    	
    }
    
    @GetMapping("/retriveAllItem")
    public List<Item> retriveAllItem()
    {
		return itemService.retriveAllItem();
    	
    }
    
    
    @GetMapping("/retriveAllNonItem")
    public List<Item> retriveAllNonItem()
    {
		return itemService.retriveAllNonItem();
    	
    }
    
}
