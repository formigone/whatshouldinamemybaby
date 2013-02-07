package com.formigone.namemybaby.client.presenter;

import java.util.List;

import com.formigone.namemybaby.client.NameMyBabyServiceAsync;
import com.formigone.namemybaby.shared.model.Baby;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class NameMyBabyPresenter implements Presenter {

	public interface Display {
		void setPresenter(Presenter presenter);
		boolean isMaleSelected();
		void setInputFocus();
		void selectInput();
		void setInput(String text);
		void setInputEnabled(boolean isEnabled);
		boolean isInputEnabled();
		void doOnVote(ClickEvent event);
		String getInput();
		Widget asWidget();
		void setData(List<Baby> babies);
	}

	private Display display;
	private NameMyBabyServiceAsync rpcService;
	private List<Baby> babies;
	
	public NameMyBabyPresenter(NameMyBabyServiceAsync rpcService, Display display) {
		this.rpcService = rpcService;
		this.display = display;
	}

	@Override
	public void go(HasWidgets container) {
		display.setPresenter(this);
		container.clear();
		container.add(display.asWidget());

		rpcService.getBabies(99, new AsyncCallback<List<Baby>>() {

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(List<Baby> result) {
				babies = result;

				display.setData(babies);
				display.setInputFocus();
				display.selectInput();
			}
		});
	}

	@Override
	public void doOnKeyPressed(KeyPressEvent event) {
		if (display.isInputEnabled()) {
			int key = (int) event.getCharCode();
			if (key == 13 /* Enter */) {
				String name = display.getInput();

				if (name.length() < 2)
					return;

				boolean gender = display.isMaleSelected();
				Baby baby = new Baby(name, gender);

				display.setInputEnabled(false);
				display.setInput("Loading...");

				rpcService.addBaby(baby, new AsyncCallback<Baby>() {

					@Override
					public void onFailure(Throwable caught) {
					}

					@Override
					public void onSuccess(Baby baby) {
						babies.add(0, baby);
						display.setData(babies);
						
						display.setInputEnabled(true);
						display.setInput("");
						display.selectInput();
					}
				});
			}
		}
	}

	@Override
	public void doOnVote(int index, boolean isUpvote) {
		Baby baby = babies.get(index);
		if (isUpvote)
			System.out.println("Up voted " + baby.getName());
		else
			System.out.println("Down voted " + baby.getName());
	}
}
