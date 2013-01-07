package com.formigone.namemybaby.client.presenter;

import com.formigone.namemybaby.client.NameMyBabyServiceAsync;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class NameMyBabyPresenter implements Presenter {

	public interface Display {
		void setPresenter(Presenter presenter);
		boolean isMaleSelected();
		void setInputFocus();
		String getInput();
		Widget asWidget();
	}

	private Display display;
	private NameMyBabyServiceAsync rpcService;
	
	public NameMyBabyPresenter(NameMyBabyServiceAsync rpcService, Display display) {
		this.rpcService = rpcService;
		this.display = display;
	}

	@Override
	public void go(HasWidgets container) {
		display.setPresenter(this);
		container.clear();
		container.add(display.asWidget());
	}
}
