package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.api.entity.Book;
import com.api.entity.Author;
import com.api.repository.AuthorRepository;
import com.api.repository.BookRepository;



@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }
    @Override
    public List<Author> findByfNameContaining(String fName){

        return authorRepository.findByfNameContaining(fName);
    }


    
}
