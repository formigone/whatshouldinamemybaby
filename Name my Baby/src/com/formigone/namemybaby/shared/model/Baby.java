package com.formigone.namemybaby.shared.model;

import java.io.Serializable;

public class Baby implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private boolean isMale;
	
	public Baby() {}

	public Baby(String name) {
		this(name, true);
	}
	
	public Baby(String name, boolean isMale) {
		this.name = name;
		this.isMale = isMale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
}
