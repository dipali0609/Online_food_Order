package com.food.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer itemId;
	@NotBlank(message = "Please enter ItemName")
	private String itemName;
	@Column(nullable = false)
	private Integer quantity;
	@Column(nullable = false)
	private Double cost;
	private String image;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cartid" , referencedColumnName = "cartid")
	Foodcart foodCart;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="restaurantId" , referencedColumnName = "restaurantId")
	Restaurant restaurant;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="categoryId")
	private Category category;
	
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Foodcart getFoodCart() {
		return foodCart;
	}
	public void setFoodCart(Foodcart foodCart) {
		this.foodCart = foodCart;
	}
	
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Item(String itemName, Integer quantity, Double cost,String image) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.cost = cost;
		this.image=image;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public String getimage() {
		return image;
	}
	public void setimage(String image) {
		this.image = image;
	}
	
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", cost=" + cost + ",image=" + image + "]";
	}
	public void categoryaOfItem(Category ca) {
		// TODO Auto-generated method stub
		this.category=ca;
	}
	public void itemAddToCart(Foodcart fc) {
		// TODO Auto-generated method stub
		this.foodCart=fc;
	}
	public void itemAddToCart(Restaurant rs) {
		// TODO Auto-generated method stub
		this.restaurant=rs;
	}
//	"itemName": "Chicken Chettinad",
//    "quantity": "10",
//    "cost": 650,
//    "image": "https://www.crazymasalafood.com/wp-content/images/Chicken-Chettinad.png"
//	
}
