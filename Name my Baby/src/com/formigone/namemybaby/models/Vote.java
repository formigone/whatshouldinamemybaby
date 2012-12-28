package com.formigone.namemybaby.models;

import java.io.Serializable;
import java.util.List;

import com.formigone.namemybaby.factories.VoterFactory;

public class Vote implements Serializable {
	private static final long serialVersionUID = -2594304631559386705L;

	private Baby baby;
	private int score;
	private List<User> downVoters;
	private List<User> upVoters;
	
	public Vote() {
		this(null);
	}
	
	public Vote(Baby baby) {
		this.baby = baby;
		score = 0;
		downVoters = VoterFactory.createVoters();
		upVoters = VoterFactory.createVoters();
	}
	
	public Baby getBaby() {
		return baby;
	}
	
	private void calculateScore() {
		int downs = downVoters.size();
		int ups = upVoters.size();
		
		if (downs > ups)
			score = 0 - downs / (downs + ups);
		else
			score = ups / (downs + ups);
	}
	
	private boolean vote(User user, boolean isUpVote) {
		if (isUpVote) {
			downVoters.remove(user);

			if (upVoters.contains(user)) {
				upVoters.remove(user);
				calculateScore();
				return false;

			} else {
				upVoters.add(user);
				calculateScore();
				return true;
			}

		} else {
			upVoters.remove(user);

			if (downVoters.contains(user)) {
				downVoters.remove(user);
				calculateScore();
				return false;

			} else {
				downVoters.add(user);
				calculateScore();
				return true;
			}
		}
	}
	
	public int getScore() {
		return score;
	}
}
