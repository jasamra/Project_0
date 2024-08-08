package com.revature.services;

import com.revature.DAOs.ReviewDAO;
import com.revature.DAOs.ReviewDAOInterface;
import com.revature.models.Review;

import java.util.List;

public class ReviewService {
    private ReviewDAO reviewDAO = new ReviewDAO();

    public List<Review> getAllReviews() {
        return reviewDAO.getAllReviews();
    }

    public List<Review> getReviewsByBookId(int bookId) {
        return reviewDAO.getReviewsByBookId(bookId);
    }

    public void insertReview(Review review) {
        reviewDAO.insertReview(review);
    }

    public void updateReview(Review review) {
        reviewDAO.updateReview(review);
    }

    public void deleteReview(int id) {
        reviewDAO.deleteReview(id);
    }
}
