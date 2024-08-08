DROP TABLE IF EXISTS Reviews;
DROP TABLE IF EXISTS Books;
DROP TABLE IF EXISTS Users;

-- Create Users Table
CREATE TABLE IF NOT EXISTS Users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Create Books Table with Correct Foreign Key Naming
CREATE TABLE IF NOT EXISTS Books (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(50) NOT NULL,
    user_id INTEGER NOT NULL,
    CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Insert Data into Users Table
INSERT INTO Users (username, email) VALUES ('Alice Johnson', 'alice@example.com');
INSERT INTO Users (username, email) VALUES ('Bob Smith', 'bob@example.com');
INSERT INTO Users (username, email) VALUES ('Charlie Brown', 'charlie@example.com');

-- Insert Data into Books Table
INSERT INTO Books (title, author, user_id) VALUES ('The Great Gatsby', 'F. Scott Fitzgerald', 1);
INSERT INTO Books (title, author, user_id) VALUES ('To Kill a Mockingbird', 'Harper Lee', 2);
INSERT INTO Books (title, author, user_id) VALUES ('1984', 'George Orwell', 3);
INSERT INTO Books (title, author, user_id) VALUES ('Moby Dick', 'Herman Melville', 1);
INSERT INTO Books (title, author, user_id) VALUES ('Pride and Prejudice', 'Jane Austen', 2);

-- Create Reviews Table
CREATE TABLE IF NOT EXISTS Reviews (
    review_id SERIAL PRIMARY KEY,
    book_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    rating INTEGER NOT NULL CHECK (rating >= 1 AND rating <= 5),
    review TEXT,
    CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES Books(book_id) ON DELETE CASCADE,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

-- Insert Sample Data into Reviews Table
INSERT INTO Reviews (book_id, user_id, rating, review) VALUES (1, 1, 5, 'Amazing!');
INSERT INTO Reviews (book_id, user_id, rating, review) VALUES (2, 2, 4, 'Great read.');
