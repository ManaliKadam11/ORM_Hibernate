package edu.jsp.uni_many_to_many.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jsp.uni_many_to_many.entity.Student;
import edu.jsp.uni_many_to_many.entity.Subject;

public class DeleteStudent {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni_many_to_many");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		String jpql = "select s from Subject s";
		
		Query query = manager.createQuery(jpql);
		
		List<Subject> subjects = (List<Subject>)query.getResultList();
		
		for (Subject subject : subjects) {
			System.out.println(subject.getId());
			List<Student> student = subject.ge

			for (Student  s: st) {
				System.out.println());
			}
	}
}
}