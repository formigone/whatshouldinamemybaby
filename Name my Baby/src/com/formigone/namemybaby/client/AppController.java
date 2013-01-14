package com.formigone.namemybaby.client;

import com.formigone.namemybaby.client.presenter.NameMyBabyPresenter;
import com.formigone.namemybaby.client.presenter.Presenter;
import com.formigone.namemybaby.client.view.NameMyBabyView;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter {

	private final NameMyBabyServiceAsync rpcService;

	public AppController (NameMyBabyServiceAsync rpcService) {
		this.rpcService = rpcService;
	}

	@Override
	public void go(HasWidgets container) {
		Presenter presenter = new NameMyBabyPresenter(rpcService, new NameMyBabyView());
		presenter.go(container);
	}

	@Override
	public void doOnKeyPressed(KeyPressEvent event) {
		// TODO Auto-generated method stub
	}
}
