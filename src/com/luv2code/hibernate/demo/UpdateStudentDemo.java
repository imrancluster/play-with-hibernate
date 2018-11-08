package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			Student myStudent = session.get(Student.class, (long)5);
			System.out.println("Get Student: " + myStudent);
			
			myStudent.setFirstName("Khan");
			
			session.getTransaction().commit();
			
			System.out.println("Get Student: " + myStudent);
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}

	}

}
