package edu.jsp.uni_many_to_many.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import edu.jsp.uni_many_to_many.entity.Student;
import edu.jsp.uni_many_to_many.entity.Subject;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni_many_to_many");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Student student = new Student();
		student.setId(1);
		student.setName("Manali");
		student.setAge(23);
		student.setGender('F');

		Subject subject1 = new Subject();
		subject1.setId(101);
		subject1.setName("Adv Java");
		subject1.setCode("A101");
		subject1.setDuration(60);

		Subject subject2 = new Subject();
		subject2.setId(102);
		subject2.setName("Web Tech");
		subject2.setCode("W102");
		subject2.setDuration(50);

		Subject subject3 = new Subject();
		subject3.setId(103);
		subject3.setName("SQL");
		subject3.setCode("S103");
		subject3.setDuration(20);

		List<Subject> subjects = new ArrayList<>();
		subjects.add(subject1);
		subjects.add(subject2);
		subjects.add(subject3);

		// mapping
		transaction.begin();
		student.setSubjects(subjects);
		manager.persist(student);
		manager.persist(subject1);
		manager.persist(subject2);
		manager.persist(subject3);
		transaction.commit();
		System.out.println("Saved!");
	}
}
