package com.binu.hibernate.demo.entity;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;  // javax.persistence are the JPA annotations
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.hibernate.annotations.SortComparator;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	
	// Map the element collection
	
	// create collection to hold images for the student
	@ElementCollection
	@CollectionTable(name="image")
	@MapKeyColumn(name="file_name")  // this is the key column for the collection
	@Column(name="image_name")       // this is the value column for the collection
//	@OrderBy                // defaults to order by map key column (file_name) ascending
	@SortComparator(ReverseStringComparator.class)
	private SortedMap<String, String> images = new TreeMap<String, String>();
	
	
	// Add a custom class to perform a custom sort -- use case is for adding your own custom complex business logic for sorting
	// Use this class as another way to generate a descending sort on a string
	public static class ReverseStringComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			 
			return o2.compareTo(o1);
		}
		
	}
	

	public Student() {
		super();
		 
	}

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public SortedMap<String, String> getImages() {
		return images;
	}

	public void setImages(SortedMap<String, String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", images=" + images + "]";
	}

	
}
