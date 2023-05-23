package com.food.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Customer 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer customerid;
	 
	 @NotBlank(message = "Please Enter Customer First Name")
	 private String customerfname;
	 
	 @NotBlank(message = "Please Enter Customer Last Name")
	 private String customerlname;
	 
	 @Column(unique = true,nullable = false)
	 @Size(max = 10, min=10, message = "Please Enter 10 Digit Mobile Number")
	 private String customermobile;
	
	 @Column(unique = true, nullable = false)
	 @NotBlank(message = "Please Enter Customer Email ID")
	 @Email
	 private String customeremailid;
	 
	 @Column(unique = true, nullable = false)
	 @Size(min = 8,message = "Password Can Not be less than 8 charactor")
	 @NotBlank(message = "Please Enter Customer Password")
	 @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).+$", message="Password must contain at least one digit, one lower char and one upper char, one special char, and doesn't contain spaces")
	 private String customerpassword;
	 
//	 @NotBlank(message = "Please Enter Customer Address")
//	 private String customeraddress;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="addressId", referencedColumnName = "addressId")
	 Address addr;
	 
	public Address getAddr() {
		return addr;
	}
	
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String customerfname, String customerlname, String customermobile,
			String customeremailid, String customerpassword) {
		super();
		
		this.customerfname = customerfname;
		this.customerlname = customerlname;
		this.customermobile = customermobile;
		this.customeremailid = customeremailid;
		this.customerpassword = customerpassword;
//		this.customeraddress = customeraddress;
	}
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
	public String getCustomerfname() {
		return customerfname;
	}
	public void setCustomerfname(String customerfname) {
		this.customerfname = customerfname;
	}
	public String getCustomerlname() {
		return customerlname;
	}
	public void setCustomerlname(String customerlname) {
		this.customerlname = customerlname;
	}
	public String getCustomermobile() {
		return customermobile;
	}
	public void setCustomermobile(String customermobile) {
		this.customermobile = customermobile;
	}
	public String getCustomeremailid() {
		return customeremailid;
	}
	public void setCustomeremailid(String customeremailid) {
		this.customeremailid = customeremailid;
	}
	public String getCustomerpassword() {
		return customerpassword;
	}
	public void setCustomerpassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}
//	public String getCustomeraddress() {
//		return customeraddress;
//	}
//	public void setCustomeraddress(String customeraddress) {
//		this.customeraddress = customeraddress;
//	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customerfname=" + customerfname + ", customerlname="
				+ customerlname + ", customermobile=" + customermobile + ", customeremailid=" + customeremailid
				+ ", customerpassword=" + customerpassword + "]";
	}

	public void assignCustomerToAddress(Address address) 
	{
		this.addr=address;
	}
	 
//	"customerfname":"",
//    "customerlname":"Gund",
//    "customermobile":8700675432,
//    "customeremailid":"dipali@gmail.com",
//    "customerpassword":"Dipali@611"
	 
	 
	 
}
