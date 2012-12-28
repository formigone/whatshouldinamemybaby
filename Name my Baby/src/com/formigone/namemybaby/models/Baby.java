package com.formigone.namemybaby.models;

import java.io.Serializable;

public class Baby implements Serializable {
	private static final long serialVersionUID = -4683574077978833879L;

	private String name;
	private BabyGender gender;
	
	public Baby() {
		this(null, null);
	}
	
	public Baby(String name, BabyGender gender) {
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public BabyGender getGender() {
		return gender;
	}
}
