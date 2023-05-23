package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.dao.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>
{

}
