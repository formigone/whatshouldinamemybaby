package com.formigone.movies.client;

import java.util.List;

import com.formigone.movies.shared.models.Movie;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MovieServiceAsync {
	void getMovies(int max, AsyncCallback<List<Movie>> callback);
	void setMovie(Movie movie, AsyncCallback<Boolean> callback);
}
