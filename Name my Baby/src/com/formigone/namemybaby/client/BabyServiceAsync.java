package com.formigone.namemybaby.client;

import java.util.List;

import com.formigone.namemybaby.models.Vote;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BabyServiceAsync {
	void getVotes(int maxVotes, AsyncCallback<List<Vote>> callback);
}
