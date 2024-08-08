package com.revature.services;

import com.revature.DAOs.BookDAO;
import com.revature.DAOs.BookDAOInterface;
import com.revature.models.Book;

import java.util.List;

public class BookService {
    private BookDAOInterface bookDAO = new BookDAO();

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public Book getBookById(int id) {
        return bookDAO.getBookById(id);
    }

    public void insertBook(Book book) {
        bookDAO.insertBook(book);
    }

    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }
}
