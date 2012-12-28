package com.formigone.namemybaby.views;

import java.util.List;

import com.formigone.namemybaby.models.Baby;
import com.formigone.namemybaby.models.Vote;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
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
		
		class VoteHandler implements ClickHandler {

			private Vote vote;
			private boolean isVoteUp;
			
			public VoteHandler(Vote vote, boolean isVoteUp) {
				this.vote = vote;
				this.isVoteUp = isVoteUp;
			}

			@Override
			public void onClick(ClickEvent event) {
				if (isVoteUp)
					Window.alert("Voting up!");
				else
					Window.alert("Voting down ='(");
			}
		}

		for (Vote vote: babyList) {
			BabyVoteView voteView = new BabyVoteView(vote);
			VoteHandler upVoteHandler = new VoteHandler(vote, true);
			VoteHandler downVoteHandler = new VoteHandler(vote, false);

			voteView.setUpVoteHandler(upVoteHandler);
			voteView.setDownVoteHandler(downVoteHandler);
			
			vpBabyList.add(voteView);
		}
	}
}
