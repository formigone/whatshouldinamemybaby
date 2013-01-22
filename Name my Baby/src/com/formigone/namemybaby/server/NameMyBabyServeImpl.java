package com.formigone.namemybaby.server;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
		List<Baby> babies = new ArrayList<Baby>();
		babies.add(new Baby("Giggo", true));
		babies.add(new Baby("Lushimimi", false));
		babies.add(new Baby("Natasha", false));
		babies.add(new Baby("Lionel", true));

		return babies;
	}
}
