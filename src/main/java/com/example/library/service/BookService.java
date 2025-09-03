package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repo;
    public BookService(BookRepository repo) { this.repo = repo; }

    public Book addBook(Book book) { return repo.save(book); }

    public List<Book> listAll(String author, String publisher, String bookName) {
        if (author != null && !author.isEmpty()) return repo.findByAuthorContainingIgnoreCase(author);
        if (publisher != null && !publisher.isEmpty()) return repo.findByPublisherContainingIgnoreCase(publisher);
        if (bookName != null && !bookName.isEmpty()) return repo.findByBookNameContainingIgnoreCase(bookName);
        return repo.findAll();
    }

    public Optional<Book> getById(Integer id) { return repo.findById(id); }

    public Book updateBook(Integer id, Book updated) {
        return repo.findById(id).map(book -> {
            if (updated.getBookName() != null) book.setBookName(updated.getBookName());
            if (updated.getAuthor() != null) book.setAuthor(updated.getAuthor());
            if (updated.getTitle() != null) book.setTitle(updated.getTitle());
            if (updated.getPublisher() != null) book.setPublisher(updated.getPublisher());
            return repo.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void deleteBook(Integer id) { repo.deleteById(id); }
}
