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

import com.food.dao.Category;
import com.food.error.GlobalExceptionHandling;
import com.food.service.CategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CategoryController 
{
	@Autowired
  private CategoryService categoryService;
	
	@PostMapping("/addCategory")
	public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category)
	{
		Category c=categoryService.addCategory(category);
		return new ResponseEntity<Category>(c, HttpStatus.CREATED);	
	}
	
	@PutMapping("/updateCategory/{cid}")
	public Category updateCategory(@PathVariable("cid") Integer categoryId, @RequestBody Category category) throws GlobalExceptionHandling
	{
		return categoryService.updateCategory(categoryId, category);
		
	}
	
	@GetMapping("/viewCategory/{cid}")
	public Category viewCategory(@PathVariable("cid") Integer categoryId) throws GlobalExceptionHandling
	{
		return categoryService.viewCategory(categoryId);
		
	}
	
	@DeleteMapping("/removeCategory/{cid}")
	public String removeCategory(@PathVariable("cid") Integer categoryId) throws GlobalExceptionHandling
	{
		categoryService.removeCategory(categoryId);
		return "Category IS deleted Successfully" ;
		
	}
	
	@GetMapping("/viewAll")
	public List<Category> viewAll()
	{
		return categoryService.viewAll();
		
	}
}
