package com.binu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.binu.hibernate.demo.entity.Student;

public class GetStudentImagesDemo {

	public static void main(String[] args) {
		 
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			// start a transaction
			session.beginTransaction();
			
			
			// get the student id with id of 1
			int theId = 1;
			Student theStudent = session.get(Student.class, theId);
			
			// print the student detail
			System.out.println("Student:  " + theStudent.getFirstName() + " " + theStudent.getLastName() + "  |  " + theStudent.getEmail());
			
			// print the associated images
			System.out.println("Associated images:  " + theStudent.getImages());
			
			// commit the transaction
			session.getTransaction().commit();
			
			// Done
			System.out.println("Done!");
			
			// 
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			// close the transaction
			session.close();
			factory.close();
			
		}
		
		
		
		
	}

}
