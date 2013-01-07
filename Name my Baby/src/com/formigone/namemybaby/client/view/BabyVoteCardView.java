package com.formigone.namemybaby.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;

public class BabyVoteCardView extends Composite {

	private static BabyVoteCardViewUiBinder uiBinder = GWT
			.create(BabyVoteCardViewUiBinder.class);

	interface BabyVoteCardViewUiBinder extends UiBinder<Widget, BabyVoteCardView> {}

	@UiField PushButton voteUp;
	@UiField PushButton voteDown;
	@UiField Label name;
	@UiField Label percent;

	public BabyVoteCardView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	
}
