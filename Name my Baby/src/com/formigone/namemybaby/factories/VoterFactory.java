package com.formigone.namemybaby.factories;

import java.util.ArrayList;
import java.util.List;

import com.formigone.namemybaby.models.Baby;
import com.formigone.namemybaby.models.BabyGender;
import com.formigone.namemybaby.models.Vote;
import com.google.appengine.api.users.User;

public class VoterFactory {
	public static List<User> createVoters() {
		return new ArrayList<User>();
	}
	
	// TODO: Remove this when done testing
	public static List<Vote> getFakeVotes() {
		List<Vote> fakeVotes = new ArrayList<Vote>();
		
		Vote vote = new Vote(new Baby("Luli", BabyGender.FEMALE));
		fakeVotes.add(vote);
		
		vote = new Vote(new Baby("Gigo", BabyGender.MALE));
		fakeVotes.add(vote);
		
		return fakeVotes;
	}
}
