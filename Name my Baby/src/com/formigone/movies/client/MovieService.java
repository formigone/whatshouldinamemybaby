package com.formigone.movies.client;

import java.util.List;

import com.formigone.movies.shared.models.Movie;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("movie-service")
public interface MovieService extends RemoteService {
	List<Movie> getMovies(int max);
	Boolean setMovie(Movie movie);
}
