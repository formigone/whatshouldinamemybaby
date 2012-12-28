package com.formigone.namemybaby.client;

import java.util.List;

import com.formigone.namemybaby.models.Baby;
import com.formigone.namemybaby.models.Vote;
import com.formigone.namemybaby.views.BabyListView;
import com.formigone.namemybaby.views.MainVotingView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Home implements EntryPoint {

	private BabyServiceAsync babyService;
	private MainVotingView mainView;
	
	@Override
	public void onModuleLoad() {

		mainView = new MainVotingView();
		mainView.setHeader(new Label("[HEADER]"));
		mainView.setBody(new Label("Loading..."));
		
		RootPanel.get().add(mainView.asWidget());

		BabyServiceAsync babyService = GWT.create(BabyService.class);
		
		AsyncCallback<List<Vote>> callback = new AsyncCallback<List<Vote>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Failed to get babys ='(");
			}

			@Override
			public void onSuccess(List<Vote> res) {
				BabyListView babyList = new BabyListView();
				babyList.setBabies(res);
				mainView.setBody(babyList.asWidget());
			}
		};
		
		babyService.getVotes(1, callback);
	}
}
