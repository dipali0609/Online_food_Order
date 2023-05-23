package com.food.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orderdata 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer itemid;
public String itemName;
public int cost;
public int quantity;
public Orderdata() {
	super();
	// TODO Auto-generated constructor stub
}
public Orderdata(Integer itemid, String itemName, int cost, int quantity) {
	super();
	this.itemid = itemid;
	this.itemName = itemName;
	this.cost = cost;
	this.quantity = quantity;
}
public Integer getItemid() {
	return itemid;
}
public void setItemid(Integer itemid) {
	this.itemid = itemid;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "AddCart [itemid=" + itemid + ", itemName=" + itemName + ", cost=" + cost + ", quantity=" + quantity + "]";
}


}
