package com.beije.spring.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beije.spring.demo.model.Studente;

@Repository
public class StudenteRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void save(Studente studente) {
		
		Session session = sessionFactory.openSession();
		session.save(studente);
		session.close();
	}
	
	public void update(Studente studente) {
		
		Session session = sessionFactory.openSession();
		session.merge(studente);
		session.close();
	}
	
	public void delete(Integer id){
		
		Session session = sessionFactory.openSession();		
		Studente studente = session.load(Studente.class, id);
		session.delete(studente);
		session.close();
	}
	
	public List<Studente> list() {
		
		//Session session = sessionFactory.openSession();		
		//List<Studente> studenti = session.createQuery("from Studente", Studente.class).getResultList();
		//List<Studente> studenti = session.createNamedQuery("tuttiglistudenti", Studente.class).getResultList();
		//session.close();
		
		//return studenti;
		
		try (Session session = sessionFactory.openSession()) {
			List<Studente> studenti = session.createNamedQuery("tuttiglistudenti", Studente.class).getResultList();
			return studenti;
		}
				
	}

	public Studente findOne(String nome) {
		
		try (Session session = sessionFactory.openSession()) {
			Studente studente = session.createQuery("from Studente where nome = 1?", Studente.class).setParameter(1, nome).getSingleResult();
			return studente;
		}

		

	}
	
}
