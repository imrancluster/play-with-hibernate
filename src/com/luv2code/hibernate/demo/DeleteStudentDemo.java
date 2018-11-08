package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		//Session session = factory.openSession();
		
		try {
					
			// Getting new 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student base on primary key
			// Student myStudent = session.get(Student.class, (long)1);
			// System.out.println("Deleting student: " + myStudent);
			
			// session.delete(myStudent);
			
			System.out.println("Deleting student where Id = 2");
			session.createQuery("delete from Student where id = 2").executeUpdate();
			
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}

	}

}
