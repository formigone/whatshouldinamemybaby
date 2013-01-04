package com.formigone.movies.server.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.formigone.movies.shared.models.Movie;


public class MovieRepository {
	private List<Movie> parseResultList(List<Movie> res) {
		List<Movie> movies = new ArrayList<Movie>();
		for (Movie movie: res)
			movies.add(movie);

		return movies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getMovies() {

		EntityManager em = EMF.get().createEntityManager();
		Query q = em.createQuery("select m from Movie m order by m.title");
		return parseResultList(q.getResultList());
	}
	
	public boolean setMovie(Movie movie) {
		EntityManager em = EMF.get().createEntityManager();

		try {
			em.persist(movie);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		
		return true;
	}
}
