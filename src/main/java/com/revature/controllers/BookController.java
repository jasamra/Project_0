package com.revature.controllers;

import com.revature.models.Book;
import com.revature.services.BookService;
import io.javalin.http.Handler;

import java.util.List;

public class BookController {
    private BookService bookService = new BookService();

    public Handler getAllBooks = ctx -> {
        List<Book> books = bookService.getAllBooks();
        ctx.json(books);
    };

    public Handler getBookById = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Book book = bookService.getBookById(id);
        if (book != null) {
            ctx.json(book);
        } else {
            ctx.status(404);
        }
    };

    public Handler createBook = ctx -> {
        Book book = ctx.bodyAsClass(Book.class);
        bookService.insertBook(book);
        ctx.status(201);
    };

    public Handler updateBook = ctx -> {
        Book book = ctx.bodyAsClass(Book.class);
        bookService.updateBook(book);
        ctx.status(204);
    };

    public Handler deleteBook = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        bookService.deleteBook(id);
        ctx.status(204);
    };
}
