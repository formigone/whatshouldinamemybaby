package com.formigone.namemybaby.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainVotingView extends Composite {

	private static MainVotingViewUiBinder uiBinder = GWT.create(MainVotingViewUiBinder.class);
	interface MainVotingViewUiBinder extends UiBinder<Widget, MainVotingView> {}

	@UiField FlowPanel header;
	@UiField FlowPanel body;

	public MainVotingView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setHeader(Widget header) {
		this.header.clear();
		this.header.add(header);
	}
	
	public void setBody(Widget body) {
		this.body.clear();
		this.body.add(body);
	}
}
