package com.formigone.namemybaby.models;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 8072458762549057524L;

	private String email;
	
	public User() {
		this(null);
	}
	
	public User(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
