package com.formigone.namemybaby.shared.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Baby implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String key;
	
	@Basic
	private String name;
	
	@Basic
	private boolean isMale;
	
	public Baby() {}

	public Baby(String name) {
		this(name, true);
	}
	
	public Baby(String name, boolean isMale) {
		this.name = name;
		this.isMale = isMale;
	}

	public String getKey() {
		return key;
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
