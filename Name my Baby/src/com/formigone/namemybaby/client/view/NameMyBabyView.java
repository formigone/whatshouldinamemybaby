package com.formigone.namemybaby.client.view;

import com.formigone.namemybaby.client.presenter.NameMyBabyPresenter;
import com.formigone.namemybaby.client.presenter.Presenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class NameMyBabyView extends Composite implements NameMyBabyPresenter.Display {

	private static NameMyBabyViewUiBinder uiBinder = GWT
			.create(NameMyBabyViewUiBinder.class);

	interface NameMyBabyViewUiBinder extends UiBinder<Widget, NameMyBabyView> {}

	@UiField TextBox input;
	@UiField PushButton genderMale;
	@UiField PushButton genderFemale;
	private Presenter presenter;

	public NameMyBabyView() {
		initWidget(uiBinder.createAndBindUi(this));
		genderMale.setEnabled(false);
		genderFemale.setEnabled(true);
		bind();
	}

	private ClickHandler handleGenderSelect = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			if (event.getSource() == genderMale) {
				genderMale.setEnabled(false);
				genderFemale.setEnabled(true);
			} else if (event.getSource() == genderFemale) {
				genderFemale.setEnabled(false);
				genderMale.setEnabled(true);
			}
		}
	};

	public void bind() {
		genderMale.addClickHandler(handleGenderSelect);
		genderFemale.addClickHandler(handleGenderSelect);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public boolean isMaleSelected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInputFocus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInput() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Widget asWidget() {
		return this;
	}
}
