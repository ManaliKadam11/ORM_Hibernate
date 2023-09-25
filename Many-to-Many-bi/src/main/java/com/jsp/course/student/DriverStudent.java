package com.jsp.course.student;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DriverStudent {
public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("manali");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	Student s1 = new Student();
	s1.setName("Manali");
	s1.setEmail("manali@gmail.com");
	
	Student s2 = new Student();
	s2.setName("Kadam");
	s2.setEmail("kadam@gmail.com");

	Student s3 = new Student();
	s3.setName("XYZ");
	s3.setEmail("xyz@gmail.com");
	
	Student s4 = new Student();
	s4.setName("Kanna");
	s4.setEmail("kanna@gmail.com");
	
	Course c1 = new Course();
	c1.setName("WebTech");
	c1.setDuration(1);
	
	Course c2 = new Course();
	c2.setName("SQL");
	c2.setDuration(1);
	
	Course c3 = new Course();
	c3.setName("JAVA");
	c3.setDuration(1);
	
	ArrayList<Course> courses = new  ArrayList<Course>();
	courses.add(c1);
	courses.add(c2);
	courses.add(c3);
	
	ArrayList<Student> students = new ArrayList<Student>();
	students.add(s1);
	students.add(s2);
	students.add(s3);
	students.add(s4);
	
	s1.setCourses(courses);
	s2.setCourses(courses);
	s3.setCourses(courses);
	s4.setCourses(courses);
	
	c1.setStudents(students);
	c2.setStudents(students);
	c3.setStudents(students);
	
	entityTransaction.begin();
	entityManager.persist(s1);
	entityManager.persist(s2);
	entityManager.persist(s3);
	entityManager.persist(s4);
	entityManager.persist(c1);
	entityManager.persist(c2);
	entityManager.persist(c3);
	entityTransaction.commit();
}
}
