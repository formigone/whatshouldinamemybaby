package com.formigone.namemybaby.client.presenter;

import com.formigone.namemybaby.client.NameMyBabyServiceAsync;
import com.formigone.namemybaby.shared.model.Baby;
import com.google.gwt.event.dom.client.KeyPressEvent;
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
		String getInput();
		Widget asWidget();
	}

	private Display display;
	private NameMyBabyServiceAsync rpcService;
	
	public NameMyBabyPresenter(NameMyBabyServiceAsync rpcService, Display display) {
		this.rpcService = rpcService;
		this.display = display;
	}

	@Override
	public void go(HasWidgets container) {
		display.setPresenter(this);
		container.clear();
		container.add(display.asWidget());
		display.setInputFocus();
		display.selectInput();
	}

	@Override
	public void doOnKeyPressed(KeyPressEvent event) {
		// TODO: Filter empty names
		if (display.isInputEnabled()) {
			int key = (int) event.getCharCode();
			if (key == 13 /* Enter */) {
				String name = display.getInput();
				boolean gender = display.isMaleSelected();
				Baby baby = new Baby(name, gender);
	
				display.setInputEnabled(false);
				display.setInput("Loading...");
				
				System.out.println("Creating new baby");
				System.out.println("  Name  : " + name);
				System.out.println("  Gender: " + (gender ? "Male" : "Female"));
			}
		}
	}
}
