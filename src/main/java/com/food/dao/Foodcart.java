package com.food.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Foodcart")
public class Foodcart 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartid;
	

	public Foodcart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="customerid" , referencedColumnName = "customerid")
	Customer customer;
	
	
	@OneToMany(mappedBy = "foodCart")
	private List<Item> itemList;

	public Integer getCartid() {
		return cartid;
	}

	public void setCartid(Integer cartid) {
		this.cartid = cartid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "Foodcart [cartid=" + cartid + "]";
	}

	public void assignCartToCustomer(Customer cus) {
		// TODO Auto-generated method stub
		this.customer=cus;
	}


	
	
}
