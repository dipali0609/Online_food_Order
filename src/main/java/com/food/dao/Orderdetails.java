package com.food.dao;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Orderdetails 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	@Column(nullable = false)
	private Date orderDate;
    @NotBlank(message = "Please Enter the Order Status")
    @Column(nullable = false)
	private String orderStatus;
	public Orderdetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	"orderDate":"2023-12-23",
//	  "orderStatus":"Pending"
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="cartid", referencedColumnName = "cartid")
	private Foodcart cart;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name="billId", referencedColumnName = "billId")
	private  Bill bill;
	
	public Foodcart getCart() {
		return cart;
	}
	public void setCart(Foodcart cart) {
		this.cart = cart;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public Orderdetails(Integer orderId, Date orderDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + "]";
	}
	public void assignOrderdetailsToBill(Bill bill2) 
	{
		// TODO Auto-generated method stub
		this.bill=bill2;
	}
	public void assignOrderdetailsToFoodcart(Foodcart fcart) {
		// TODO Auto-generated method stub
		this.cart=fcart;
	}
	
	
}
