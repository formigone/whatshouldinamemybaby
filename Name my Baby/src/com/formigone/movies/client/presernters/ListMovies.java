package com.formigone.movies.client.presernters;

import java.util.List;

import com.formigone.movies.client.MovieServiceAsync;
import com.formigone.movies.shared.models.Movie;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

public class ListMovies implements Presenter {

	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	public interface Display {
		void setData(List<Movie> movies);
		void setPresenter(Presenter presenter);
		int getClickedCard(PresenterView sender);
		void setInputFocus();
		void selectInput();
		Widget asWidget();
	}
	
	private Display display;
	private List<Movie> movies;
	private MovieServiceAsync movieService;

	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	public ListMovies(Display display, MovieServiceAsync movieService) {
		this.display = display;
		this.display.setPresenter(this);
		this.movieService = movieService;
	}
	
	@Override
	public void onSearch(String query) {
		Movie movie = new Movie(query, 1999);
		movieService.setMovie(movie, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("RPC failed ='(");
			}

			@Override
			public void onSuccess(Boolean result) {
				System.out.println("New movie saved.");
				display.selectInput();
				fetchMovies();
			}
		});
	}
	
	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	public void fetchMovies() {
		movieService.getMovies(10, new AsyncCallback<List<Movie>>() {

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("RPC failed ='(");
			}

			@Override
			public void onSuccess(List<Movie> result) {
				movies = result;
				display.setData(movies);
			}
		});
	}

	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	@Override
	public void go(Panel container) {
		container.clear();
		container.add(display.asWidget());
		display.setInputFocus();
		
		fetchMovies();
	}

	// --------------------------------------------------------
	//
	// --------------------------------------------------------
	@Override
	public void onMovieCardClick(PresenterView sender) {
		int movieIndex = display.getClickedCard(sender);
		
		if (movieIndex >= 0) {
			Movie movie = movies.get(movieIndex);
			System.out.println("Card clicked: " + movie.getTitle());
		}
	}
}
