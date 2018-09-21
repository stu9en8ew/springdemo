package com.beije.spring.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beije.spring.demo.model.Studente;

@Repository
public class StudenteRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void save(Studente studente) {
		
		try(Session session = sessionFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			session.save(studente);
			transaction.commit();
		}
		
	}
	
	public void update(Studente studente) {
				
		try(Session session = sessionFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			session.merge(studente);
			transaction.commit();
		}

	}
	
	public void delete(Integer id){
		
		try(Session session = sessionFactory.openSession()){
			Transaction transaction = session.beginTransaction();
			Studente studente = session.load(Studente.class, id);
			session.delete(studente);
			transaction.commit();
		}
		
	}
	
	public List<Studente> list() {
		
		//Session session = sessionFactory.openSession();		
		//List<Studente> studenti = session.createQuery("from Studente", Studente.class).getResultList();
		//List<Studente> studenti = session.createNamedQuery("tuttiglistudenti", Studente.class).getResultList();
		//session.close();
		
		//return studenti;
		
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			List<Studente> studenti = session.createNamedQuery("tuttiglistudenti", Studente.class).getResultList();
			transaction.commit();
			return studenti;
		}
				
	}

	public Studente findOne(String nome) {
		
		try (Session session = sessionFactory.openSession()) {
			Transaction transaction = session.beginTransaction();
			Studente studente = session.createQuery("from Studente where nome = ?1", Studente.class).setParameter(1, nome).getSingleResult();
			transaction.commit();
			return studente;
		}

	}

	public Studente findById(Integer id) {
		
		try(Session session = sessionFactory.openSession()){
			Studente studente = session.createQuery("from Studente where id = ?1", Studente.class).setParameter(1, id).getSingleResult();
			return studente;
		}
		
	}
	
}
