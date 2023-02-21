package com.jsp.service;

import java.util.List;

import com.jsp.dao.ReviewDao;
import com.jsp.dto.Review;

public class ReviewService {
	ReviewDao reviewDao = new ReviewDao();

	public void update(Review review) {
		reviewDao.update(review);
	}

	public void delete(Review review) {
		reviewDao.delete(review);
	}

	public Review readById(Review review) {
		return reviewDao.readById(review);
	}

	public void deleteAll(List<Review> alReviews) {
		reviewDao.deleteAll(alReviews);
	}
}
