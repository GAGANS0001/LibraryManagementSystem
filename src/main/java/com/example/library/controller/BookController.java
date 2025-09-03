package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;



    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping

    public ResponseEntity<Book> addBook(@RequestBody  Book book) {
        Book saved = service.addBook(book);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Book>> listBooks(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String publisher,
            @RequestParam(required = false, name = "bookName") String bookName) {
        return ResponseEntity.ok(service.listAll(author, publisher, bookName));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody Book updated) {
        try {
            Book b = service.updateBook(id, updated);
            return ResponseEntity.ok(b);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        service.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
