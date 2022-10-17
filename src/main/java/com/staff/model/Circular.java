package com.staff.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "Circular")
public class Circular {

	
	private Integer id;
	private String subject;
	private String discription;
	private String date;
	private String acknowledge;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getAcknowledge() {
		return acknowledge;
	}
	public void setAcknowledge(String acknowledge) {
		this.acknowledge = acknowledge;
	}
	public Circular(Integer id, String subject, String discription, String date, String acknowledge) {
		super();
		this.id = id;
		this.subject = subject;
		this.discription = discription;
		this.date = date;
		this.acknowledge = acknowledge;
	}

	public Circular() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
