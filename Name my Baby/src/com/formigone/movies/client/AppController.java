package com.formigone.movies.client;

import com.formigone.movies.client.presernters.ListMovies;
import com.formigone.movies.client.presernters.Presenter;
import com.formigone.movies.client.presernters.PresenterView;
import com.formigone.movies.client.views.ListMoviesView;
import com.google.gwt.user.client.ui.Panel;

public class AppController implements Presenter {

	@Override
	public void onSearch(String query) {
	}

	private MovieServiceAsync movieService;
	
	public AppController(MovieServiceAsync movieService) {
		this.movieService = movieService;
	}
	
	@Override
	public void go(Panel container) {
		Presenter presenter = new ListMovies(new ListMoviesView(), movieService); 
		presenter.go(container);
	}

	@Override
	public void onMovieCardClick(PresenterView sender) {
	}
}
