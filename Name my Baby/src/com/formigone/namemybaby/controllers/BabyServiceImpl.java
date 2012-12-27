package com.formigone.namemybaby.controllers;

import java.util.List;

import com.formigone.namemybaby.client.BabyService;
import com.formigone.namemybaby.factories.VoterFactory;
import com.formigone.namemybaby.models.Vote;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class BabyServiceImpl extends RemoteServiceServlet implements BabyService {

	private static final long serialVersionUID = 8947119192257772493L;

	@Override
	public List<Vote> getVotes(int maxVotes) {
		// TODO: Get votes from datastore
		List<Vote> votes = VoterFactory.getFakeVotes();

		return votes;
	}
}
