package com.formigone.namemybaby.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class NameMyBaby implements EntryPoint {

	@Override
	public void onModuleLoad() {
		NameMyBabyServiceAsync rpcService = GWT.create(NameMyBabyService.class);
		AppController appController = new AppController(rpcService);
		appController.go(RootPanel.get());
	}
}
