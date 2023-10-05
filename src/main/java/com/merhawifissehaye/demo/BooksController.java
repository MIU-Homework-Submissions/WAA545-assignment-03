package com.merhawifissehaye.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BooksController {
    ArrayList<Book> books;

    BooksController() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Lord of the Rings", "978-0618640157", "J. R. R. Tolkien", 12.99));
        books.add(new Book(2, "The Hobbit", "978-0547928227", "J. R. R. Tolkien", 12.99));
        books.add(new Book(3, "The Silmarillion", "978-0618391110", "J. R. R. Tolkien", 12.99));
        books.add(new Book(4, "The Power of Now", "978-0618391111", "Eckhart Tolle", 12.99));
        this.books = books;
    }

    @GetMapping(value = "", headers = "X-API-Version=2")
    public List<Book> allBooks() {
        return this.books;
    }

    @GetMapping(value = "/{id}", produces = "application/cs.miu.edu-v2+json")
    public Book getBookById(@PathVariable("id") int id) {
        System.out.println("I am here");
        return this.books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = "application/cs.miu.edu-v2+json")
    public Book addBook(@RequestBody Book book) {
        // TODO store the book in the database
        return book;
    }

    @PutMapping(value = "/{id}", consumes = "application/cs.miu.edu-v2+json")
    public Book update(@RequestBody Book book) {
        // TODO update the book in the database
        return book;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        // TODO delete the book from the database
        return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
    }
}
