package edu.jsp.uni_many_to_many.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jsp.uni_many_to_many.entity.Student;
import edu.jsp.uni_many_to_many.entity.Subject;

public class DeleteSubject {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni_many_to_many");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		String jpql = "select s from Student s";

		Query query = manager.createQuery(jpql);

		List<Student> students = (List<Student>) query.getResultList();

		for (Student student : students) {
			System.out.println(student.getId());
			List<Subject> subjects = student.getSubjects();

			for (Subject subject : subjects) {
				System.out.println(subject.getId());
			}
		}
	}
}
