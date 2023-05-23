package com.food.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contactus 
{

	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int contactid;
private String contactname;
private String contactemailid;
private String contactmessage;
public Contactus() {
	super();
	// TODO Auto-generated constructor stub
}
public Contactus(int contactid, String contactname, String contactemailid, String contactmessage) {
	super();
	this.contactid = contactid;
	this.contactname = contactname;
	this.contactemailid = contactemailid;
	this.contactmessage = contactmessage;
}
public int getContactid() {
	return contactid;
}
public void setContactid(int contactid) {
	this.contactid = contactid;
}
public String getContactname() {
	return contactname;
}
public void setContactname(String contactname) {
	this.contactname = contactname;
}
public String getContactemailid() {
	return contactemailid;
}
public void setContactemailid(String contactemailid) {
	this.contactemailid = contactemailid;
}
public String getContactmessage() {
	return contactmessage;
}
public void setContactmessage(String contactmessage) {
	this.contactmessage = contactmessage;
}
@Override
public String toString() {
	return "Contactus [contactid=" + contactid + ", contactname=" + contactname + ", contactemailid=" + contactemailid
			+ ", contactmessage=" + contactmessage + "]";
}


	
}
