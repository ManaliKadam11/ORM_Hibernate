package edu.jsp.bi_many_to_many.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

import edu.jsp.bi_many_to_many.entity.Student;
import edu.jsp.bi_many_to_many.entity.Subject;

public class SaveStudent {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bi_many_to_many");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Student student1 = new Student();
		student1.setId(1);
		student1.setName("Mana");
		student1.setAge(22);
		student1.setGender('F');

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("Kanna");
		student2.setAge(21);
		student2.setGender('M');

		Subject subject1 = new Subject();
		subject1.setId(1);
		subject1.setName("React.js");
		subject1.setCode("Rec12");
		subject1.setDuration(12);

		Subject subject2 = new Subject();
		subject2.setId(2);
		subject2.setName("SQL");
		subject2.setCode("SQL122");
		subject2.setDuration(22);

		Subject subject3 = new Subject();
		subject3.setId(3);
		subject3.setName("Testing");
		subject3.setCode("Te55");
		subject3.setDuration(30);

		subject1.setStudents(Arrays.asList(student1));
		subject2.setStudents(Arrays.asList(student2));

		List<Subject> Mana = new ArrayList<>();
		Mana.add(subject2);
		Mana.add(subject3);

		List<Subject> Kanna = new ArrayList<>();
		Kanna.add(subject1);
		Kanna.add(subject2);

		transaction.begin();
		student1.setSubjects(Kanna);
		student2.setSubjects(Mana);
		manager.persist(student1);
		manager.persist(student2);
		manager.persist(subject1);
		manager.persist(subject2);
		manager.persist(subject3);
		transaction.commit();

		System.out.println("Saved");
	}
}
