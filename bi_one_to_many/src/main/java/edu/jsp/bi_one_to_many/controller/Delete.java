package edu.jsp.bi_one_to_many.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.bi_one_to_many.entity.Product;
import edu.jsp.bi_one_to_many.entity.Review;

public class Delete {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bi_one_to_many");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		Product product = manager.find(Product.class, 1);
		List<Review> reviews = product.getReviews();

		Review target = null;

		for (Review review : reviews) {
			if (review.getId() == 2) {
				target = review;
			}
		}

		if (target != null) {
			transaction.begin();
			manager.remove(target);
			product.setReviews(reviews);
			manager.merge(product);
			manager.merge(target);
			transaction.commit();
			System.out.println("Review deleted!");
		}

		else {
			System.out.println("Not deleted!");
		}
	}
}
