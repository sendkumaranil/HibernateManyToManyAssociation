package com.hibernate.association.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory=buildSessionFactory();
	
	private static SessionFactory buildSessionFactory(){
		try{
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}

}
