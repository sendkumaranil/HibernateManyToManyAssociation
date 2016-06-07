package com.hibernate.association.client;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.association.model.Address;
import com.hibernate.association.model.Person;
import com.hibernate.association.util.HibernateUtil;

public class TestClient {

	public static void main(String[] args) {
		//testConnection();
		createPerson();
		
		
	}
	private static void createPerson(){
		Transaction tx=null;
		try{
		SessionFactory sessionFactory=HibernateUtil.getSessionfactory();
		Session session=sessionFactory.openSession();
		tx=session.beginTransaction();

		Person p1=new Person();
		p1.setFirstName("Avinash");
		p1.setLastName("Singh");
		
		Person p2=new Person();
		p2.setFirstName("Rajeev");
		p2.setLastName("Ranjan");
		
		Address address1=new Address();
		address1.setBuildingName("Avi Nilyam");
		address1.setTown("Bangalore");
		address1.setPostCode("560034");
		
		Address address2=new Address();
		address2.setBuildingName("RJ Paradise");
		address2.setTown("Mysuru");
		address2.setPostCode("450023");
		
		Address address3=new Address();
		address3.setBuildingName("RJ House");
		address3.setTown("Dhanbad");
		address3.setPostCode("620032");
		
		p1.getAddresses().add(address1);
		p2.getAddresses().add(address2);
		p2.getAddresses().add(address3);
		
		System.out.println("Creating Person:"+p1.getFirstName());
		session.persist(p1);
		System.out.println("Creating Person:"+p2.getFirstName());
		session.persist(p2);
		
		tx.commit();
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			
		}	
	}
	
	private static void testConnection(){
		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {
			System.out.println("Getting Connection please wait...");
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			System.out.println("You made it, take control your database now!");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		
	  }
}
