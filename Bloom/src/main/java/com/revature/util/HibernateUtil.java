package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Session session;

	private static SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public static Session getSession() {
		if(session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
		}
		
		return session;
	}
	
	public static void closeSession() {
		session.close();
	}
}
