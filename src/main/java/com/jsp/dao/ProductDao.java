package com.jsp.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.Product;
import com.jsp.dto.Review;

public class ProductDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void create(Product p) {
		entityTransaction.begin();
		entityManager.persist(p);
		entityTransaction.commit();

	}

	public void update(Product product) {
		Product product2 = entityManager.find(Product.class, product.getId());
		entityTransaction.begin();
		if (product.getName() != null) {
			product2.setName(product.getName());
		}
		if (product.getBrand() != null) {
			product2.setBrand(product.getBrand());
		}
		if (product.getCost() != null) {
			product2.setCost(product.getCost());
		}
		if (product.getType() != null) {
			product2.setType(product.getType());
		}
		if (product.getReview() != null) {
			product2.setReview(product.getReview());
		}
		entityManager.merge(product2);
		entityTransaction.commit();
	}

	public void delete(Product product) {
		Product product2 = entityManager.find(Product.class, product.getId());
		entityTransaction.begin();
		entityManager.remove(product2);
		entityTransaction.commit();

	}

	public Product readById(Product product) {
		return entityManager.find(Product.class, product.getId());
	}
}
