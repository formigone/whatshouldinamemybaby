package com.formigone.namemybaby.views;

import com.formigone.namemybaby.models.Baby;
import com.formigone.namemybaby.models.Vote;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;

public class BabyVoteView extends Composite {

	private static BabyVoteViewUiBinder uiBinder = GWT.create(BabyVoteViewUiBinder.class);
	interface BabyVoteViewUiBinder extends UiBinder<Widget, BabyVoteView> {}

	@UiField PushButton btnVoteUp;
	@UiField PushButton btnVoteDown;
	@UiField Label lblName;

	public BabyVoteView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public BabyVoteView(Vote vote) {
		this();

		Baby baby = vote.getBaby();
		lblName.setText(baby.getName());
		
		btnVoteUp.setLayoutData(vote);
		btnVoteDown.setLayoutData(vote);
	}
	
	public void setUpVoteHandler(ClickHandler clickHandler) {
		btnVoteUp.addClickHandler(clickHandler);
	}
	
	public void setDownVoteHandler(ClickHandler clickHandler) {
		btnVoteDown.addClickHandler(clickHandler);
	}
}
