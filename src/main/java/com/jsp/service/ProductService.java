package com.jsp.service;

import java.util.ArrayList;
import java.util.List;

import com.jsp.dao.ProductDao;
import com.jsp.dto.Product;
import com.jsp.dto.Review;

public class ProductService {
	ProductDao productDao = new ProductDao();

	public void create(Product p) {
		productDao.create(p);
	}

	public void update(Product product) {
		productDao.update(product);
	}

	public void delete(Product product, List<Review> alreviews) {
		ReviewService reviewService = new ReviewService();
		reviewService.deleteAll(alreviews);
		productDao.delete(product);
	}

	public Product readById(Product product) {
		return productDao.readById(product);
	}
}
