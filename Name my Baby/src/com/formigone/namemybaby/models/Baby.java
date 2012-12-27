package com.formigone.namemybaby.models;

public class Baby {
	private String name;
	private BabyGender gender;
	
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
