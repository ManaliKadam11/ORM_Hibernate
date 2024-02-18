package edu.jsp.uni_many_to_many.controller;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.uni_many_to_many.entity.Student;
import edu.jsp.uni_many_to_many.entity.Subject;

public class AddStudent {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni_many_to_many");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Student student = new Student();
		student.setId(2);
		student.setName("Sam");
		student.setAge(22);
		student.setGender('F');

		Subject subject = manager.find(Subject.class, 103);

		transaction.begin();
		student.setSubjects(Arrays.asList(subject));
		manager.persist(student);
		transaction.commit();
	}
}
