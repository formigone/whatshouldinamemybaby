package com.formigone.movies.client.views.fragments;

import com.formigone.movies.client.presernters.Presenter;
import com.formigone.movies.client.presernters.PresenterView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MovieCardView extends Composite implements PresenterView {

	private static MovieCardViewUiBinder uiBinder = GWT.create(MovieCardViewUiBinder.class);

	interface MovieCardViewUiBinder extends UiBinder<Widget, MovieCardView> {}

	@UiField Label title;
	private Presenter presenter;

	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	@UiHandler("title")
	public void onMovieCardClick(ClickEvent event) {
		if (presenter != null)
			presenter.onMovieCardClick(this);
	}

	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	public MovieCardView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	public void setTitle(String title) {
		this.title.setText(title);
	}
}
