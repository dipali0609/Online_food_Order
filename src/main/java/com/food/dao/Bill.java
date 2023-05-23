
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

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer billId;
	@Future
	@Column(nullable = false)
	private Date billDate;
	@Column(nullable = false)
	private Double totalCost;
	@Column(nullable = false)
	private Integer totalItem;
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="orderId", referencedColumnName = "orderId")
	private Orderdetails order;
	
	
	
	public Orderdetails getOrder() {
		return order;
	}
	public void setOrder(Orderdetails order) {
		this.order = order;
	}
	public Bill(Integer billId, Date billDate, Double totalCost, Integer totalItem) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		this.totalCost = totalCost;
		this.totalItem = totalItem;
	}
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public Integer getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Integer totalItem) {
		this.totalItem = totalItem;
	}
	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billDate=" + billDate + ", totalCost=" + totalCost + ", totalItem="
				+ totalItem + "]";
	}
	
	public void assignBillToOrderdetails(Orderdetails order2) {
		// TODO Auto-generated method stub
		this.order=order2;	
	}
	
	
	
}
