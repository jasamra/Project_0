package com.revature.DAOs;

import com.revature.models.Book;

import java.util.List;

public interface BookDAOInterface {
    List<Book> getAllBooks();
    Book getBookById(int id);
    void insertBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);

    //TODO: MAYBE show delete, but it should be easy if you know how to update

}
