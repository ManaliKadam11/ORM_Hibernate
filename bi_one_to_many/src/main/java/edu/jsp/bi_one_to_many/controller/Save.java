package edu.jsp.bi_one_to_many.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.bi_one_to_many.entity.Product;
import edu.jsp.bi_one_to_many.entity.Review;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bi_one_to_many");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Product product = new Product();
		product.setId(2);
		product.setName("Clothes");
		product.setCost(30000);
		product.setRating(5);

		Review review1 = new Review();
		review1.setId(103);
		review1.setHeading("Nice");
		review1.setMessage("Worth of money!");
		review1.setProduct(product);

		Review review2 = new Review();
		review2.setId(104);
		review2.setHeading("One of best purchase");
		review2.setMessage("The cloth is so smooth and good");
		review2.setProduct(product);

		List<Review> reviews = new ArrayList<>();
		reviews.add(review1);
		reviews.add(review2);

		product.setReviews(reviews);

		transaction.begin();
		manager.persist(product);
		manager.persist(review1);
		manager.persist(review2);
		transaction.commit();
		System.out.println("Saved!");
	}
}
