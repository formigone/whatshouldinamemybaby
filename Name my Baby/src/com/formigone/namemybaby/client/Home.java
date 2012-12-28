package com.formigone.namemybaby.client;

import java.util.List;

import com.formigone.namemybaby.models.Baby;
import com.formigone.namemybaby.models.Vote;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

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
				for (Vote vote: res) {
					Baby baby = vote.getBaby();
					Label label = new Label(baby.getName());
					
					RootPanel.get().add(label);
				}
			}
		};
		
		babyService.getVotes(1, callback);
	}
}
