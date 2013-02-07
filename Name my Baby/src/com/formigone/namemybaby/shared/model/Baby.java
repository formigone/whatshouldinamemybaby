package com.formigone.namemybaby.shared.model;

import java.io.Serializable;
import java.util.ArrayList;

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
	private Long key;
	
	@Basic
	private String name;
	
	@Basic
	private boolean isMale;
	
/*	@Basic
	private ArrayList<String> upVotes;
	
	@Basic
	private ArrayList<String> downVotes;
	
*/	public Baby() {}

	public Baby(String name) {
		this(name, true);
	}
	
	public Baby(String name, boolean isMale) {
		this.name = name;
		this.isMale = isMale;
/*		upVotes = new ArrayList<String>();
		downVotes = new ArrayList<String>();
*/	}

	public Long getKey() {
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
	
	public int getScore() {
		return 0;
/*		int up = upVotes.size();
		int down = downVotes.size();
		int total = up + down;
		
		if (total == 0)
			return total;

		if (down > up)
			return down / total * -100;
		
		return up / total * 100;
*/	}
	
	public void voteUp(String voter) {
/*		// Unvote
		if (upVotes.contains(voter)) {
			upVotes.remove(voter);
			return;
		}
		
		downVotes.remove(voter);
		upVotes.add(voter);
*/	}
	
	public void voteDown(String voter) {
/*		// Unvote
		if (downVotes.contains(voter)) {
			downVotes.remove(voter);
			return;
		}
		
		downVotes.add(voter);
		upVotes.remove(voter);
*/	}
}
