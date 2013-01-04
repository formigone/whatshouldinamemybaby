package com.formigone.movies.server.factory;

import com.formigone.movies.server.repository.MovieRepository;

public class MovieFactory {
	private MovieRepository repository;
	
	public MovieFactory() {
		this.repository = new MovieRepository();
	}
	
	public MovieRepository getMovieRepository() {
		return repository;
	}
	
	public void setRepository(MovieRepository repository) {
		this.repository = repository;
	}
}
