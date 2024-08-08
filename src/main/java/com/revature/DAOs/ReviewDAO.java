package com.revature.DAOs;

import com.revature.models.Review;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO implements ReviewDAOInterface {

    @Override
    public List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM Reviews";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Review review = new Review(
                        rs.getInt("review_id"),
                        rs.getInt("book_id"),
                        rs.getInt("user_id"),
                        rs.getInt("rating"),
                        rs.getString("review")
                );
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public List<Review> getReviewsByBookId(int bookId) {
        List<Review> reviews = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM Reviews WHERE book_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bookId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Review review = new Review(
                        rs.getInt("review_id"),
                        rs.getInt("book_id"),
                        rs.getInt("user_id"),
                        rs.getInt("rating"),
                        rs.getString("review")
                );
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public void insertReview(Review review) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO Reviews (book_id, user_id, rating, review) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, review.getBook_id());
            pstmt.setInt(2, review.getUser_id());
            pstmt.setInt(3, review.getRating());
            pstmt.setString(4, review.getReview());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateReview(Review review) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE Reviews SET rating = ?, review = ? WHERE review_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, review.getRating());
            pstmt.setString(2, review.getReview());
            pstmt.setInt(3, review.getReview_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReview(int id) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "DELETE FROM Reviews WHERE review_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
