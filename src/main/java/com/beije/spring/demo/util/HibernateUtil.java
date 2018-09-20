/*package com.beije.spring.demo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil {
	
	public SessionFactory factory;
	
	public synchronized SessionFactory geSessionFactory() {
		
		if (factory == null) {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
		}
		
		return factory;
		
	}

}
*/