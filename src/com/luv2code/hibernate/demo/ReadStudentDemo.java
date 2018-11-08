package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		//Session session = factory.openSession();
		
		try {
			
			System.out.println("Creating new student obejct ..");
			Student student1 = new Student("Irfan", "Hossain", "irfan@gmail.om");
			
			session.beginTransaction();
			
			System.out.println("Saving ..");
			System.out.println(student1);
			session.save(student1);
			
			session.getTransaction().commit();
			
			
			System.out.println("Saved student. Generated ID: " + student1.getId());
			
			// Getting new 
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student base on primary key
			Student myStudent = session.get(Student.class, student1.getId());
			System.out.println("Get Student: " + myStudent);
			
			session.getTransaction().commit();
					
					
			System.out.println("Done");
			
		} finally {
			factory.close();
		}

	}

}
