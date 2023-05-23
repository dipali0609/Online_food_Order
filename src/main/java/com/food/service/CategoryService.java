package com.food.service;

import java.util.List;

import javax.validation.Valid;

import com.food.dao.Category;
import com.food.error.GlobalExceptionHandling;

public interface CategoryService {

	public Category addCategory(@Valid Category category);

	void removeCategory(Integer categoryId) throws GlobalExceptionHandling;

	Category viewCategory(Integer categoryId) throws GlobalExceptionHandling;

	public Category updateCategory(Integer categoryId,Category category) throws GlobalExceptionHandling;

	public List<Category> viewAll();




}
