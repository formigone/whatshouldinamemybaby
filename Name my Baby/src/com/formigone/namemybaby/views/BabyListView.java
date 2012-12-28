package com.formigone.namemybaby.views;

import java.util.List;

import com.formigone.namemybaby.models.Baby;
import com.formigone.namemybaby.models.Vote;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class BabyListView extends Composite {

	private static BabyListUiBinder uiBinder = GWT.create(BabyListUiBinder.class);
	interface BabyListUiBinder extends UiBinder<Widget, BabyListView> {}

	@UiField VerticalPanel vpBabyList;
	
	public BabyListView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setBabies(List<Vote> babyList) {
		vpBabyList.clear();

		for (Vote vote: babyList) {
			Baby baby = vote.getBaby();
			Label name = new Label(baby.getName());
			
			vpBabyList.add(name);
		}
	}
}
