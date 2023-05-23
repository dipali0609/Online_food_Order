
package com.food.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.Category;
import com.food.error.GlobalExceptionHandling;
import com.food.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
	private CategoryRepository categoryRepository;
	@Override
	public Category addCategory(@Valid Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}
	@Override
	public void removeCategory(Integer categoryId) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Category> c=categoryRepository.findById(categoryId);
		if(!c.isPresent())
		{
			throw new GlobalExceptionHandling(categoryId+" Is Not Present");
		}
		else
		{
			categoryRepository.deleteById(categoryId);
		}
		
	}
	@Override
	public Category viewCategory(Integer categoryId) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Category> c=categoryRepository.findById(categoryId);
		if(!c.isPresent())
		{
			throw new GlobalExceptionHandling(categoryId+" Is Not Present");
		}
		else
		{
			
		  return categoryRepository.findById(categoryId).get(); 	
		}
		
	}
	@Override
	public Category updateCategory(Integer categoryId,Category category) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Category> c=categoryRepository.findById(categoryId);
		if(!c.isPresent())
		{
			throw new GlobalExceptionHandling(categoryId+" Is Not Present");
		}
		else
		{
			Category c1=categoryRepository.findById(categoryId).get();
			if(c1!=null)
			{
				c1.setCategoryName(category.getCategoryName());
				return categoryRepository.save(c1);
			}
			return c1;
		}
		
	}
	@Override
	public List<Category> viewAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

}
