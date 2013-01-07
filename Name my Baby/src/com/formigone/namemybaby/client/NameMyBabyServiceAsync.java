package com.formigone.namemybaby.client;

import com.formigone.namemybaby.shared.model.Baby;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NameMyBabyServiceAsync {
	public void addBaby(Baby baby, AsyncCallback<Baby> callback);
}
