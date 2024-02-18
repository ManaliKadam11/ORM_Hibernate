package edu.jsp.uni_many_to_many.controller;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.uni_many_to_many.entity.Student;
import edu.jsp.uni_many_to_many.entity.Subject;

public class Find {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("uni_many_to_many");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Student student = manager.find(Student.class, 1);
		List<Subject> subjects = student.getSubjects();

		System.out.println("-----------------------");
		System.out.println("Student id: " + student.getId());
		System.out.println("Student name: " + student.getName());
		System.out.println("Student Gender: " + student.getGender());
		System.out.println("Student Age: " + student.getAge());

		for (Subject subject : subjects) {
			System.out.println("-----------------------");
			System.out.println("Subject id: " + subject.getId());
			System.out.println("Subject Name: " + subject.getName());
			System.out.println("Subject Code: " + subject.getCode());
			System.out.println("Subject Duration: " + subject.getDuration());
		}
	}
}
