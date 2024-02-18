package edu.jsp.uni_many_to_many.controller;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.uni_many_to_many.entity.Student;
import edu.jsp.uni_many_to_many.entity.Subject;

public class RemoveSubject {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni_many_to_many");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Student student = manager.find(Student.class, 1);

		List<Subject> subjects = student.getSubjects();

		Iterator<Subject> iterator = subjects.iterator();

		while (iterator.hasNext()) {
			Subject subject = (Subject) iterator.next();
			subjects.remove(subject);
			break;
		}

		transaction.begin();
		student.setSubjects(subjects);
		manager.merge(student);
		transaction.commit();
		System.out.println("Removed!");
	}
}
