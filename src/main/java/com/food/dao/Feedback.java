package com.food.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int feedabackid;
private String feedbackname;
private String feedbackemail;
private String feedbacksubject;
private String feedbackmessage;
public Feedback() {
	super();
	// TODO Auto-generated constructor stub
}
public Feedback(int feedabackid, String feedbackname, String feedbackemail, String feedbacksubject,
		String feedbackmessage) {
	super();
	this.feedabackid = feedabackid;
	this.feedbackname = feedbackname;
	this.feedbackemail = feedbackemail;
	this.feedbacksubject = feedbacksubject;
	this.feedbackmessage = feedbackmessage;
}
public int getFeedabackid() {
	return feedabackid;
}
public void setFeedabackid(int feedabackid) {
	this.feedabackid = feedabackid;
}
public String getFeedbackname() {
	return feedbackname;
}
public void setFeedbackname(String feedbackname) {
	this.feedbackname = feedbackname;
}
public String getFeedbackemail() {
	return feedbackemail;
}
public void setFeedbackemail(String feedbackemail) {
	this.feedbackemail = feedbackemail;
}
public String getFeedbacksubject() {
	return feedbacksubject;
}
public void setFeedbacksubject(String feedbacksubject) {
	this.feedbacksubject = feedbacksubject;
}
public String getFeedbackmessage() {
	return feedbackmessage;
}
public void setFeedbackmessage(String feedbackmessage) {
	this.feedbackmessage = feedbackmessage;
}
@Override
public String toString() {
	return "Feedback [feedabackid=" + feedabackid + ", feedbackname=" + feedbackname + ", feedbackemail="
			+ feedbackemail + ", feedbacksubject=" + feedbacksubject + ", feedbackmessage=" + feedbackmessage + "]";
}


}
