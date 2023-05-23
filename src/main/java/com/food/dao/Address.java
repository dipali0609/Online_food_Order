package com.food.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer addressId;
	@NotBlank(message = "Please Enter Area")
	private String area;
	@NotBlank(message = "Please Enter City")
	private String city;
	@NotBlank(message = "Please Enter State")
	private String state;
	@NotBlank(message = "Please Enter country")
	private String country;
	@NotBlank(message = "Please Enter Pincode")
	private String pincode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
//	"area":"Newasa",
//	  "city":"Newasa",
//	  "state":"Maharashtra",
//	  "country":"India",
//	  "pincode":"414603"
//	
	public Address(String area, String city, String state, String country, String pincode) {
		super();
		
		this.area = area;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", area=" + area + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", pincode=" + pincode + "]";
	}
	
	
}
