package com.example.library.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;

// DataBase file

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "book_name", nullable = true)
    private String bookName;

    @NotBlank
    @Column(nullable = true)
    private String author;


    private String title;
    private String publisher;

    // Constructors
    public Book() {}
    public Book(String bookName, String author, String title, String publisher) {
        this.bookName = bookName;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
    }

    // Getters & setters
    public Integer getBookId() { return bookId; }
    public void setBookId(Integer bookId) { this.bookId = bookId; }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
}
