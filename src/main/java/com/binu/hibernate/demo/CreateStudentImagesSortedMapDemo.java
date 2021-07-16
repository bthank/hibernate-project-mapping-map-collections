package com.binu.hibernate.demo;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.binu.hibernate.demo.entity.Student;

public class CreateStudentImagesSortedMapDemo {

	
	public static void main(String[] args) {
		
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
		
		// create the object
			Student tempStudent = new Student("Jill","Fournier","jill_fournier@msn.com");
			Map<String,String> theImages = tempStudent.getImages();

			theImages.put("photo1.jpg","Photo 1");
			theImages.put("photo2.jpg","Photo 2");
			theImages.put("photo3.jpg","Photo 3");
			theImages.put("photo4.jpg","Photo 4");
			theImages.put("photo5.jpg","Photo 5");   
		
		// start a transaction
			session.beginTransaction();
		
		// save the object
			System.out.println("Saving the student and images ...");
			session.persist(tempStudent);
		
		// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done saving!!");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		// do code cleanup
		finally {
			session.close();
			factory.close();
		}
		
		
	}
	
	
	
}
