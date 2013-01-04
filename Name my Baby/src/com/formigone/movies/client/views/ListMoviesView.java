package com.formigone.movies.client.views;

import java.util.List;

import com.formigone.movies.client.presernters.ListMovies;
import com.formigone.movies.client.presernters.Presenter;
import com.formigone.movies.client.presernters.PresenterView;
import com.formigone.movies.client.views.fragments.MovieCardView;
import com.formigone.movies.shared.models.Movie;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ListMoviesView extends Composite implements ListMovies.Display, PresenterView {

	private static ListMoviesViewUiBinder uiBinder = GWT.create(ListMoviesViewUiBinder.class);
	interface ListMoviesViewUiBinder extends UiBinder<Widget, ListMoviesView> {}
	
	// TODO: Create inner interface for fragments! That way any fragment would know to set its presenter, title, etc. AND fragments can be polymorphic
	// TODO: Create ListMoviesViewFactory?

	@UiField HTMLPanel container;
	@UiField TextBox inputBox;
	private Presenter presenter;
	private static int ENTER_KEY = 13;

	public ListMoviesView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	@UiHandler("inputBox")
	public void onSearch(KeyUpEvent event) {
		if (event.getNativeKeyCode() == ENTER_KEY) {
			if (presenter != null)
				presenter.onSearch(inputBox.getText());
		}
	}

	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	@Override
	public void setInputFocus() {
		inputBox.setFocus(true);
	}

	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	@Override
	public void selectInput() {
		inputBox.selectAll();
	}

	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	@Override
	public void setData(List<Movie> movies) {
		container.clear();

		for(Movie movie : movies) {
			MovieCardView card = new MovieCardView();
			card.setTitle(movie.getTitle());
			
			if (presenter != null)
				card.setPresenter(presenter);

			container.add(card);
		}
	}

	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	@Override
	public Widget asWidget() {
		return this;
	}

	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	@Override
	public int getClickedCard(PresenterView sender) {
		return container.getWidgetIndex((MovieCardView) sender);
	}
}
