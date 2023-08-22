package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dto.BookAuthorDTO;
import com.api.entity.Book;

import com.api.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping()
    public Book addBook(@RequestBody Book book) {
        System.out.println(book);
        return bookService.saveBook(book);
    }
    @GetMapping("/names")
    public List<BookAuthorDTO> findBookNamesAndAuthorNames(){
        return bookService.findBookNamesAndAuthorNames();

    }
}