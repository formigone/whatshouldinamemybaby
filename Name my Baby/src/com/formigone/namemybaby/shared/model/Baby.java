package com.formigone.namemybaby.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	
	@Basic
	private List<String> upVotes;
	
	@Basic
	private List<String> downVotes;
	
	public Baby() {}

	public Baby(String name) {
		this(name, true);
	}
	
	public Baby(String name, boolean isMale) {
		this.name = name;
		this.isMale = isMale;
		upVotes = new ArrayList<String>();
		downVotes = new ArrayList<String>();
	}

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

	public void fixVotes() {
		List<String> tmpUps = new ArrayList<String>();
		for (String str : upVotes)
			tmpUps.add(str);

		upVotes = null;
		upVotes = tmpUps;

		List<String> tmpDowns = new ArrayList<String>();
		for (String str : downVotes)
			tmpDowns.add(str);

		downVotes = null;
		downVotes = tmpDowns;

		System.out.println("Votes type: " + upVotes.getClass());
		System.out.println("Ups: " + upVotes.size());
		System.out.println("Downs: " + downVotes.size());
	}

	/**
	 * What out for that integer division!
	 * @return int score The ratio between up votes and down votes. If there are more down votes, the ratio is negative.
	 */
	public int getScore() {

		int up = upVotes.size();
		int down = downVotes.size();
		int total = up + down;

		if (total == 0)
			return total;

		if (down > up)
			return (int) (down / ((float) total) * -100);

		return (int) (up / ((float) total) * 100);
	}
	
	public void voteUp(String voter) {
		// Unvote
		if (upVotes.contains(voter)) {
			upVotes.remove(voter);
			return;
		}
		
		downVotes.remove(voter);
		upVotes.add(voter);
	}
	
	public void voteDown(String voter) {
		// Unvote
		if (downVotes.contains(voter)) {
			downVotes.remove(voter);
			return;
		}
		
		downVotes.add(voter);
		upVotes.remove(voter);
	}
}
