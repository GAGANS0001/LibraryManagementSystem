package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthorContainingIgnoreCase(String author);
    List<Book> findByPublisherContainingIgnoreCase(String publisher);
    List<Book> findByBookNameContainingIgnoreCase(String bookName);
}
