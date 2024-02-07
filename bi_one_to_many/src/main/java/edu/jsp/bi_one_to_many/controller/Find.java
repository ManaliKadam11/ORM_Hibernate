package edu.jsp.bi_one_to_many.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.bi_one_to_many.entity.Product;
import edu.jsp.bi_one_to_many.entity.Review;

public class Find {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("bi_one_to_many");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
	
		
		Product product =manager.find(Product.class, 1);
		List<Review> reviews = product.getReviews();
		
		System.out.println("-------------------------------------");
		System.out.println(product.getId());
		System.out.println(product.getCost());
		System.out.println(product.getName());
		System.out.println(product.getRating());
		
		
		for(Review review: reviews) {
			System.out.println("-------------------------------------");
			System.out.println(review.getId());
			System.out.println(review.getHeading());
			System.out.println(review.getMessage());
		}
	}
}
