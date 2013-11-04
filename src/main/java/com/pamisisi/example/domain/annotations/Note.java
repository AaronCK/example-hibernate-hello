package com.pamisisi.example.domain.annotations;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Note {
	
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private User user;
	private byte[] context;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public byte[] getContext() {
		return context;
	}
	public void setContext(byte[] context) {
		this.context = context;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
