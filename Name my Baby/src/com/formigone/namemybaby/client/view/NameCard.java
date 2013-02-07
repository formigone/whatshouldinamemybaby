package com.formigone.namemybaby.client.view;

import com.formigone.namemybaby.client.view.res.R;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class NameCard extends Composite implements NameMyBabyView.NameVoter {

	private static NameCardUiBinder uiBinder = GWT.create(NameCardUiBinder.class);

	interface NameCardUiBinder extends UiBinder<Widget, NameCard> {}
	
	private R r = GWT.create(R.class);
	private NameMyBabyView parentView;
	@UiField FlowPanel card;
	@UiField Button upVote;
	@UiField Button downVote;
	@UiField Label name;
	@UiField Label percent;

	public NameCard(String name, boolean isBoy, int percent) {
		r.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		
		if (!isBoy)
			cardAsGirl();
		else
			cardAsBoy();
		
		this.name.setText(name);
		setPercent(percent);
	}
	
	public NameCard() {
		this("Noname", true, 0);
	}
	
	private void setPercent(int percent) {
		this.percent.setText(percent + "%");

		if (percent < 0) {
			this.percent.removeStyleName(r.css().percentPositive());
			this.percent.addStyleName(r.css().percentNegative());
		} else {
			this.percent.removeStyleName(r.css().percentNegative());
			this.percent.addStyleName(r.css().percentPositive());
		}
	}

	private void cardAsGirl() {
		card.removeStyleName(r.css().nameCardBoy());
		card.addStyleName(r.css().nameCardGirl());
	}
	
	private void cardAsBoy() {
		card.removeStyleName(r.css().nameCardGirl());
		card.addStyleName(r.css().nameCardBoy());
	}

	@Override
	public void setParent(NameMyBabyView parentView) {
		this.parentView = parentView;
	}

	@UiHandler({"upVote", "downVote"})
	@Override
	public void handleOnVote(ClickEvent event) {
		if (parentView != null)
			parentView.doOnVote(event);
	}

	@Override
	public boolean hasBtn(Button btn) {
		return upVote == btn || downVote == btn;
	}
	
	@Override
	public boolean isUpVote(Button btn) {
		return upVote == btn;
	}
}
