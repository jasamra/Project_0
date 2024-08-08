package com.revature.DAOs;

import com.revature.models.Review;
import java.util.List;

public interface ReviewDAOInterface {

    List<Review> getAllReviews();
    List<Review> getReviewsByBookId(int bookId);
    void insertReview(Review review);
    void updateReview(Review review);
    void deleteReview(int id);
}
