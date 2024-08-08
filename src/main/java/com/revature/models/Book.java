package com.revature.models;
public class Book {

    private int book_id;
    private String title;
    private String author;
    private User user;
    private int user_id_fk;

    // No-args constructor
    public Book() {
    }

    // All-args constructor
    public Book(int book_id, String title, String author, User user) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.user = user;
    }

    // Constructor for DAO operations (without user object)
    public Book(int book_id, String title, String author, int user_id_fk) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.user_id_fk = user_id_fk;
    }

    // Getters and setters
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public int getUser_id_fk() {
        return user_id_fk;
    }

    public void setUser_id_fk(int user_id_fk) {
        this.user_id_fk = user_id_fk;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", user_id_fk=" + user_id_fk +
                '}';
    }
}