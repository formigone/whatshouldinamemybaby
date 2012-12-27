package com.formigone.namemybaby.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Home implements EntryPoint {

	@Override
	public void onModuleLoad() {
		RootPanel.get().add(new Label("Name my baby: Home"));
	}
}
