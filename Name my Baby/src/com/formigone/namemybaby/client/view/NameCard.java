package com.formigone.namemybaby.client.view;

import com.formigone.namemybaby.client.view.res.R;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class NameCard extends Composite {

	private static NameCardUiBinder uiBinder = GWT.create(NameCardUiBinder.class);

	interface NameCardUiBinder extends UiBinder<Widget, NameCard> {}
	
	private R r = GWT.create(R.class);
	@UiField FlowPanel card;
	@UiField Button upVote;
	@UiField Button downVote;
	@UiField Label name;
	@UiField Label percent;

	public NameCard(boolean isBoy) {
		r.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		
		if (!isBoy)
			cardAsGirl();
		else
			cardAsBoy();
	}
	
	public NameCard() {
		this(true);
	}
	
	// TODO: Include in Presenter.Interface
	public void setName(String name) {
		this.name.setText(name);
		setPercent(Random.nextInt(80) - 20);
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
}
