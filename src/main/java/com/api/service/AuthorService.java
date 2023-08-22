package com.api.service;

import java.util.List;

import com.api.entity.Author;

public interface AuthorService {
    List<Author> getAllAuthors();
    Author saveAuthor(Author author);
    List<Author> findByfNameContaining(String fName);
}
