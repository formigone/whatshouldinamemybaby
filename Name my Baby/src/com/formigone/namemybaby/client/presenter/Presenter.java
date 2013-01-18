package com.formigone.namemybaby.client.presenter;

import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.user.client.ui.HasWidgets;

public interface Presenter {
	public void go(final HasWidgets container);
	public void doOnKeyPressed(KeyPressEvent event);
	public void doOnVote();
}
