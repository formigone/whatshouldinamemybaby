package com.formigone.namemybaby.client;

import com.formigone.namemybaby.client.view.NameCard;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class NameMyBaby implements EntryPoint {

	@Override
	public void onModuleLoad() {
/*		NameMyBabyServiceAsync rpcService = GWT.create(NameMyBabyService.class);
		AppController appController = new AppController(rpcService);
		appController.go(RootPanel.get());*/
		
		NameCard[] names = new NameCard[] {
			new NameCard(),
			new NameCard(false),
			new NameCard(false),
			new NameCard()
		};
		
		names[0].setName("Giggo");
		names[1].setName("Lushimimi");
		names[2].setName("Natasha");
		names[3].setName("Lionel");

		RootPanel.get().add(names[0]);
		RootPanel.get().add(names[1]);
		RootPanel.get().add(names[2]);
		RootPanel.get().add(names[3]);
	}
}
