package com.formigone.namemybaby.server;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.formigone.namemybaby.client.NameMyBabyService;
import com.formigone.namemybaby.shared.model.Baby;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class NameMyBabyServeImpl extends RemoteServiceServlet implements
		NameMyBabyService {

	private static final long serialVersionUID = 1L;

	@Override
	public Baby addBaby(Baby baby) {
		EntityManager em = EMF.get().createEntityManager();
		
		try {
			System.out.println("Persisting baby");
			em.getTransaction().begin();
			em.persist(baby);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("D'OH! Exception thrown. Rolling back transaction.");
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			System.out.println("Closing entity manager");
			em.close();
		}
		
		return baby;
	}

	@Override
	public List<Baby> getBabies(int max) {
		EntityManager em = EMF.get().createEntityManager();
		String q = "select b from Baby b order by b.name";
		Query query = em.createQuery(q);

		System.out.println("Query babies list: " + q);
		
		@SuppressWarnings("unchecked")
		List<Baby> babies = new ArrayList<Baby>(query.getResultList());

		for (int i = 0; i < babies.size(); i++) {
			System.out.println("Fixing votes");
			babies.get(i).fixVotes();
		}

		em.close();

		return babies;
	}
	
	@Override
	public Baby upVote(Baby baby) {
		EntityManager em = EMF.get().createEntityManager();
		String q = "select b from Baby b order by b.name";
		Query query = em.createQuery(q);

		System.out.println("Query baby: " + q);
		HttpServletRequest request = getThreadLocalRequest();
		HttpSession session = request.getSession();
		
		baby = (Baby)query.getSingleResult();
		baby.voteUp(session.getId());

		return baby;
	}
}
