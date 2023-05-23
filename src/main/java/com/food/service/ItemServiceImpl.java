package com.food.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dao.Category;
import com.food.dao.Foodcart;
import com.food.dao.Item;
import com.food.dao.Restaurant;
import com.food.error.GlobalExceptionHandling;
import com.food.repository.CategoryRepository;
import com.food.repository.FoodcartRepository;
import com.food.repository.ItemRepository;
import com.food.repository.RestaurantRepository;

@Service
public class ItemServiceImpl implements ItemService
{
    @Autowired
	private ItemRepository itemRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private FoodcartRepository foodcartRepository;
    
    @Autowired
    private RestaurantRepository restaurantRepository;
    
	@Override
	public Item saveItem(@Valid Item item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}

	@Override
	public Item updateItem(Integer itemId, Item item) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Item> it=itemRepository.findById(itemId);
		if(!it.isPresent())
		{
			throw new GlobalExceptionHandling(itemId+" Is Not Present");
		}
		else
		{
			Item itt=itemRepository.findById(itemId).get();
			if(itt!=null)
			{
				itt.setItemName(item.getItemName());
				itt.setQuantity(item.getQuantity());
				itt.setCost(item.getCost());
				return itemRepository.save(itt);
			}
			return itt;
		}
		
	}

	@Override
	public Item viewItemById(Integer itemId) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Item> it=itemRepository.findById(itemId);
		if(!it.isPresent())
		{
			throw new GlobalExceptionHandling(itemId+" Is Not Present");
		}
		else
		{
		    return itemRepository.findById(itemId).get();
		}
	}

	@Override
	public void removeItemById(Integer itemId) throws GlobalExceptionHandling {
		// TODO Auto-generated method stub
		Optional<Item> it=itemRepository.findById(itemId);
		if(!it.isPresent())
		{
			throw new GlobalExceptionHandling(itemId+" Is Not Present");
		}
		else
		{
			itemRepository.deleteById(itemId);
		}
	}

	@Override
	public List<Item> viewAllItem() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

	@Override
	public Item categoryaOfItem(Integer itemId, Integer categoryId) {
		// TODO Auto-generated method stub
		Item it=itemRepository.findById(itemId).get();
		Category ca=categoryRepository.findById(categoryId).get();
		it.categoryaOfItem(ca);
		return itemRepository.save(it);
	}

	@Override
	public Item itemAddToCart(Integer itemId, Integer cartid) {
		// TODO Auto-generated method stub
		Item it=itemRepository.findById(itemId).get();
		Foodcart fc=foodcartRepository.findById(cartid).get();
		it.itemAddToCart(fc);
		return itemRepository.save(it);	
	}

	@Override
	public Item restaurentassignTocart(Integer itemId, Integer restaurantId) {
		// TODO Auto-generated method stub
		Item it=itemRepository.findById(itemId).get();
		Restaurant rs=restaurantRepository.findById(restaurantId).get();
		it.itemAddToCart(rs);
		return itemRepository.save(it);	
	}

	@Override
	public List<Item> retriveAllItem() {
		// TODO Auto-generated method stub
		return itemRepository.retriveAllItem();
	}

	@Override
	public List<Item> retriveAllNonItem() {
		// TODO Auto-generated method stub
		return itemRepository.retriveAllNonItem();
	}

}
