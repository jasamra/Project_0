package com.revature;

import com.revature.controllers.UserController;
import com.revature.controllers.BookController;
import com.revature.controllers.ReviewController;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        // Try-with-resources block to ensure the connection is closed automatically
        try (Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("CONNECTION SUCCESSFUL :)");
        } catch (SQLException e) {
            e.printStackTrace(); // Tell us what went wrong
            System.out.println("connection failed :(");
        }

        // Typical Javalin setup syntax
        Javalin app = Javalin.create(config -> {
            // Any extra configurations would go here
        }).start(3000);

        // Callable resource just for fun
        app.get("/", ctx -> ctx.result("Hello Postman!"));

        // Instantiate Controllers so we can access their Handlers
        UserController userController = new UserController();
        BookController bookController = new BookController();
        ReviewController reviewController = new ReviewController();

        // User endpoints
        app.get("/users", userController.getAllUsers);
        app.get("/users/{id}", userController.getUserById);
        app.post("/users", userController.createUser);
        app.put("/users", userController.updateUser);
        app.delete("/users/{id}", userController.deleteUser);

        // Book endpoints
        app.get("/books", bookController.getAllBooks);
        app.get("/books/{id}", bookController.getBookById);
        app.post("/books", bookController.createBook);
        app.put("/books", bookController.updateBook);
        app.delete("/books/{id}", bookController.deleteBook);

        // Review endpoints
        app.get("/reviews", reviewController.getAllReviews);
        app.get("/books/{bookId}/reviews", reviewController.getReviewsByBookId);
        app.post("/reviews", reviewController.createReview);
        app.put("/reviews", reviewController.updateReview);
        app.delete("/reviews/{id}", reviewController.deleteReview);
    }
}
