package com.formigone.namemybaby.client;

import java.util.List;

import com.formigone.namemybaby.models.Vote;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Home implements EntryPoint {

	private BabyServiceAsync babyService;
	
	@Override
	public void onModuleLoad() {

		BabyServiceAsync babyService = GWT.create(BabyService.class);
		
		AsyncCallback<List<Vote>> callback = new AsyncCallback<List<Vote>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Failed to get babys ='(");
			}

			@Override
			public void onSuccess(List<Vote> res) {
				Window.alert("Got babies just fine! =)");
			}
		};
		
		babyService.getVotes(1, callback);
	}
}
