package com.formigone.namemybaby.client;

import com.formigone.namemybaby.client.view.NameCard;
import com.formigone.namemybaby.client.view.NameMyBabyView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class NameMyBaby implements EntryPoint {

	@Override
	public void onModuleLoad() {
/*		NameMyBabyServiceAsync rpcService = GWT.create(NameMyBabyService.class);
		AppController appController = new AppController(rpcService);
		appController.go(RootPanel.get());*/
		
		NameMyBabyView view = new NameMyBabyView();
		RootPanel.get().add(view);
		view.setInputFocus();
		view.selectInput();
	}
}
