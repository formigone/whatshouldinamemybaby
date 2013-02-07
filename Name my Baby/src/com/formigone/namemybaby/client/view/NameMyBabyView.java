package com.formigone.namemybaby.client.view;

import java.util.Date;
import java.util.List;

import com.formigone.namemybaby.client.presenter.NameMyBabyPresenter;
import com.formigone.namemybaby.client.presenter.Presenter;
import com.formigone.namemybaby.client.view.res.R;
import com.formigone.namemybaby.shared.model.Baby;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class NameMyBabyView extends Composite implements NameMyBabyPresenter.Display {

	private static NameMyBabyViewUiBinder uiBinder = GWT
			.create(NameMyBabyViewUiBinder.class);

	interface NameMyBabyViewUiBinder extends UiBinder<Widget, NameMyBabyView> {}

	@UiField TextBox input;
	@UiField Button genderMale;
	@UiField Button genderFemale;
	@UiField FlowPanel namesContainer;
	@UiField SpanElement birthTimer;
	private Presenter presenter;
	private R r = GWT.create(R.class);
	
	public interface NameVoter {
		void setParent(NameMyBabyView parentView);
		void handleOnVote(ClickEvent event);
		boolean hasBtn(Button btn);
		boolean isUpVote(Button btn);
	}

	public NameMyBabyView() {
		r.css().ensureInjected();
		initWidget(uiBinder.createAndBindUi(this));
		input.getElement().setAttribute("placeholder", "Suggest a name");
		markDown(true);
		bind();
	}

	private ClickHandler handleGenderSelect = new ClickHandler() {
		@Override
		public void onClick(ClickEvent event) {
			if (isInputEnabled()) {
				if (event.getSource() == genderMale)
					markDown(true);
				else if (event.getSource() == genderFemale) 
					markDown(false);
				
				setInputFocus();
				selectInput();
			}
		}
	};
	
	private void markDown(boolean asBoy) {
		if (asBoy) {
			genderMale.setEnabled(false);
			genderFemale.setEnabled(true);
			genderMale.removeStyleName(r.css().genderSelectBoy());
			genderMale.addStyleName(r.css().genderSelectBoyDown());
			genderFemale.removeStyleName(r.css().genderSelectGirlDown());
			genderFemale.addStyleName(r.css().genderSelectGirl());
		} else {
			genderFemale.setEnabled(false);
			genderMale.setEnabled(true);
			genderFemale.removeStyleName(r.css().genderSelectGirl());
			genderFemale.addStyleName(r.css().genderSelectGirlDown());
			genderMale.removeStyleName(r.css().genderSelectBoyDown());
			genderMale.addStyleName(r.css().genderSelectBoy());
		}
	}

	public void bind() {
		genderMale.addClickHandler(handleGenderSelect);
		genderFemale.addClickHandler(handleGenderSelect);

		input.addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if (presenter != null)
					presenter.doOnKeyPressed(event);
			}
		});
		
		Timer timer = new Timer() {

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				Date date = new Date();
				Date dueDate = new Date();
				dueDate.setMonth(7);
				dueDate.setDate(19);
				dueDate.setHours(0);
				dueDate.setMinutes(0);
				dueDate.setSeconds(0);
				long sec = (dueDate.getTime() - date.getTime()) / 1000;
				int hour = (int) (sec / 3600);
				sec %= 3600;
				int min = (int) (sec / 60);
				sec %= 60;
				
				birthTimer.setInnerText((hour < 10 ? "0" : "") + hour + ":" + 
						(min < 10 ? "0" : "") + min + ":" + 
						(sec < 10 ? "0" : "") + sec);
			}
		};
		
		timer.scheduleRepeating(1000);
	}
	
	@Override
	public void setData(List<Baby> babies) {
		
		namesContainer.clear();
		
		for (Baby baby : babies) {
			NameCard nameCard = new NameCard(baby.getName(), baby.isMale(), baby.getScore());
			nameCard.setParent(this);
			namesContainer.add(nameCard);
		}
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public boolean isMaleSelected() {
		return !genderMale.isEnabled();
	}

	@Override
	public void setInputFocus() {
		input.setFocus(true);
	}

	@Override
	public String getInput() {
		return input.getText();
	}
	
	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void selectInput() {
		input.selectAll();
	}

	@Override
	public void setInput(String text) {
		this.input.setText(text);
	}

	@Override
	public void setInputEnabled(boolean isEnabled) {
		input.setEnabled(isEnabled);
	}

	@Override
	public boolean isInputEnabled() {
		return input.isEnabled();
	}

	@Override
	public void doOnVote(ClickEvent event) {
		Button btn = (Button) event.getSource();
		for (int i = 0; i < namesContainer.getWidgetCount(); i++) {
			NameCard card = (NameCard) namesContainer.getWidget(i);

			if (card.hasBtn(btn)) {
				if (presenter != null)
					presenter.doOnVote(i, card.isUpVote(btn));
				break;
			}
		}
	}
}
