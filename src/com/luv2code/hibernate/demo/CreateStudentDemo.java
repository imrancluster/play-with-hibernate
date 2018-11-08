package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

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
					Student student1 = new Student("Imran2", "Sarder", "imrancluster2@gmail.om");
					Student student2 = new Student("Imran3", "Sarder", "imrancluster3@gmail.om");
					Student student3 = new Student("Imran4", "Sarder", "imrancluster4@gmail.om");
					
					session.beginTransaction();
					
					System.out.println("Saving ..");
					session.save(student1);
					session.save(student2);
					session.save(student3);
					
					session.getTransaction().commit();
					
					System.out.println("Done");
					
				} finally {
					factory.close();
				}

	}

}
