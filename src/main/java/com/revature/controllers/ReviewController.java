package com.revature.controllers;

import com.revature.models.Review;
import com.revature.services.ReviewService;
import io.javalin.http.Handler;

import java.util.List;

public class ReviewController {
    private ReviewService reviewService = new ReviewService();

    public Handler getAllReviews = ctx -> {
        List<Review> reviews = reviewService.getAllReviews();
        ctx.json(reviews);
    };

    public Handler getReviewsByBookId = ctx -> {
        int bookId = Integer.parseInt(ctx.pathParam("bookId"));
        List<Review> reviews = reviewService.getReviewsByBookId(bookId);
        ctx.json(reviews);
    };

    public Handler createReview = ctx -> {
        Review review = ctx.bodyAsClass(Review.class);
        reviewService.insertReview(review);
        ctx.status(201);
    };

    public Handler updateReview = ctx -> {
        Review review = ctx.bodyAsClass(Review.class);
        reviewService.updateReview(review);
        ctx.status(204);
    };

    public Handler deleteReview = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        reviewService.deleteReview(id);
        ctx.status(204);
    };
}
