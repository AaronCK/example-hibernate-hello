package com.pamisisi.example.domain.xml;

import java.util.Date;

public class Note {
	private Long id;
	private User user;
	private byte[] context;
	
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
