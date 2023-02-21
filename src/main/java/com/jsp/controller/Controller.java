package com.jsp.controller;

import java.util.ArrayList;

import com.jsp.dto.Product;
import com.jsp.dto.Review;
import com.jsp.service.ProductService;
import com.jsp.service.ReviewService;

public class Controller {
	public static void main(String[] args) {
		Product product = new Product();
		product.setName("TSHIRT");
		product.setBrand("ZARA");
		product.setCost(1500.00);
		product.setType("CLOTHING");

		Review review1 = new Review();
		review1.setRating(4);
		review1.setStatus("GOOD");
		review1.setProduct(product);

		Review review2 = new Review();
		review2.setRating(4);
		review2.setStatus("GOOD");
		review2.setProduct(product);

		Review review3 = new Review();
		review3.setRating(4);
		review3.setStatus("VERY GOOD");
		review3.setProduct(product);

//		TO DELETE A PRODUCT Record .class.WE HAVE TO DELETE ALL THE REVIEWS FIRST..
//		THATS WHY SETTING THE ID'S FOR EACH REVIEWS
//		review1.setId(4);
//		review1.setId(5);
//		review1.setId(6);

		ArrayList<Review> al = new ArrayList<Review>();
		al.add(review1);
		al.add(review2);
		al.add(review3);

		product.setReview(al);

//		---------------------PRODUCT OPERATIONS-------------------------
		ProductService productService = new ProductService();

//		SAVE PRODUCT AND REVIEW
		productService.create(product);

//		UPDATE PRODUCT
		product.setId(2);
		productService.update(product);

//		DELETE PRODUCT
		product.setId(2);
		productService.delete(product, al);

//		READ PRODUCT BY ID
		product.setId(1);
		Product product2 = productService.readById(product);
		System.out.println(product2.getId());
		System.out.println(product2.getName());
		System.out.println(product2.getBrand());
		System.out.println(product2.getType());

//		 ------------------REVIEW OPERATIONS------------------
		ReviewService reviewService = new ReviewService();

//		UPDATE REVIEW
		review1.setId(1);
		reviewService.update(review1);

//		DELETE REVIEW
		review1.setId(1);
		reviewService.delete(review1);

//		READ REVIEW BY ID
		review1.setId(2);
		Review review = reviewService.readById(review1);
		System.out.println(review.getId());
		System.out.println(review.getRating());
		System.out.println(review.getStatus());

		System.out.println("All Good");

	}

}
