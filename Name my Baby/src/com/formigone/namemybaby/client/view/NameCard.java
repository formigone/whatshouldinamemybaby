package com.formigone.namemybaby.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class NameCard extends Composite {

	private static NameCardUiBinder uiBinder = GWT.create(NameCardUiBinder.class);

	interface NameCardUiBinder extends UiBinder<Widget, NameCard> {}

	public NameCard() {
		initWidget(uiBinder.createAndBindUi(this));
	}
}
