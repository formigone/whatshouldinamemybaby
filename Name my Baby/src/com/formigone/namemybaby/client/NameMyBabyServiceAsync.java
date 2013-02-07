package com.formigone.namemybaby.client;

import java.util.List;

import com.formigone.namemybaby.shared.model.Baby;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NameMyBabyServiceAsync {
	public void addBaby(Baby baby, AsyncCallback<Baby> callback);
	public void getBabies(int max, AsyncCallback<List<Baby>> callback);
	public void upVote(Baby baby, AsyncCallback<Baby> callback);
}
