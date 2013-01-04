package com.formigone.movies.server;

import java.util.List;

import com.formigone.movies.client.MovieService;
import com.formigone.movies.server.factory.MovieFactory;
import com.formigone.movies.server.repository.MovieRepository;
import com.formigone.movies.shared.models.Movie;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class MovieServiceImpl extends RemoteServiceServlet implements MovieService {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Movie> getMovies(int max) {
		MovieFactory movieFactory = new MovieFactory();
		MovieRepository movieRepository = movieFactory.getMovieRepository();

		List<Movie> movies = movieRepository.getMovies();

		return movies;
	}

	@Override
	public Boolean setMovie(Movie movie) {
		MovieFactory movieFactory = new MovieFactory();
		MovieRepository movieRepository = movieFactory.getMovieRepository();
		
		boolean success = movieRepository.setMovie(movie);

		return new Boolean(success);
	}
}
