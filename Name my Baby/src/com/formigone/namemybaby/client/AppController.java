package com.formigone.namemybaby.client;

import com.formigone.namemybaby.client.presenter.NameMyBabyPresenter;
import com.formigone.namemybaby.client.presenter.Presenter;
import com.formigone.namemybaby.client.view.NameMyBabyView;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter {

	private final NameMyBabyServiceAsync rpcService;
	private HasWidgets container;

	public AppController (NameMyBabyServiceAsync rpcService) {
		this.rpcService = rpcService;
	}

	@Override
	public void go(HasWidgets container) {
		this.container = container;
		
		Presenter presenter = new NameMyBabyPresenter(rpcService, new NameMyBabyView());
		presenter.go(container);
	}
}
