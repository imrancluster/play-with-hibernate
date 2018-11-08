package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		//Session session = factory.openSession();
		
		try {
			
			session.beginTransaction();
					
			// Query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			displayStudents(theStudents);
			
			// query for first_name : Sarder
			System.out.println("\n\nQuery lastName = Hossain");
			theStudents = session.createQuery("from Student s where s.lastName = 'Hossain' ").list();
			displayStudents(theStudents);
			
			System.out.println("\n\nQuery firstName = Imran3 OR lastName = Hossain");
			theStudents = session.createQuery("from Student s where s.firstName = 'Imran3' OR s.lastName = 'Hossain'").list();
			displayStudents(theStudents);
			
			System.out.println("\n\nQuery email LIKE '%imrancluster%'");
			theStudents = session.createQuery("from Student s where s.email LIKE '%imrancluster%' ").list();
			displayStudents(theStudents);
			
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}

	}

	/**
	 * @param theStudents
	 */
	private static void displayStudents(List<Student> theStudents) {
		// Display
		for(Student student: theStudents) {
			System.out.println(student);
		}
	}

}
