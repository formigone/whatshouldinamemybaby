package com.formigone.movies.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class Home implements EntryPoint {

	@Override
	public void onModuleLoad() {
		MovieServiceAsync rpcService = GWT.create(MovieService.class);
		AppController appController = new AppController(rpcService);
		appController.go(RootPanel.get("movies_panel"));
	}
}
