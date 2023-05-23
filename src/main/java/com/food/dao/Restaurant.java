package com.food.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Restaurant 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer restaurantId;
	@NotBlank(message = "Please Enter Restaurant Name")
	@Column(nullable = false)
	private String restaurantName;
	@NotBlank(message = "Please Enter Manager Name")
	@Column(nullable = false)
	private String managerName;
	@Column(unique = true,nullable = false)
	@Size(max = 10, min=10, message = "Please Enter 10 Digit Mobile Number")
	private String contactNumber;
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	 "restaurantName":"",
//	 "managerName":"Sharmila",
//	 "contactNumber":8976543219
	 
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId", referencedColumnName = "addressId")
	private Address address;
	
	
	@OneToMany(mappedBy = "restaurant")
	private List<Item> itemList = new ArrayList<>();
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Restaurant(String restaurantName, String managerName, String contactNumber) {
		super();
		
		this.restaurantName = restaurantName;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
	}
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", managerName="
				+ managerName + ", contactNumber=" + contactNumber + "]";
	}
	public void assignRestaurantToAddress(Address addr2) {
		// TODO Auto-generated method stub
		this.address=addr2;
	}
	
}
