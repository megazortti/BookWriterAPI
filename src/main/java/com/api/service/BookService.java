package com.api.service;

import java.util.List;

import com.api.dto.BookAuthorDTO;
import com.api.entity.Book;

public interface BookService {
    List<Book> getAllBooks();
    Book saveBook(Book book);
    List<BookAuthorDTO> findBookNamesAndAuthorNames();
}