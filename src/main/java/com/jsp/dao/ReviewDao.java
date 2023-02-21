package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.Review;

public class ReviewDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void update(Review review) {
		Review review2 = entityManager.find(Review.class, review.getId());
		if (review2 != null) {
			entityTransaction.begin();
			review2.setRating(review.getRating());
			review2.setStatus(review.getStatus());
			entityManager.merge(review2);
			entityTransaction.commit();
		} 
	}

	public void delete(Review review) {
		Review review2 = entityManager.find(Review.class, review.getId());
		if (review2 != null) {
			entityTransaction.begin();
			entityManager.remove(review2);
			entityTransaction.commit();
		} 
	}

	public Review readById(Review review) {
		return entityManager.find(Review.class, review.getId());
	}

	public void deleteAll(List<Review> alReviews) {
		for (Review review : alReviews) {
			Review review2 = entityManager.find(Review.class, review.getId());
			entityTransaction.begin();
			entityManager.remove(review2);
			entityTransaction.commit();

		}
	}
}
