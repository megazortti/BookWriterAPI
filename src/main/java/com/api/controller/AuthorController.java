package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.Author;
import com.api.service.AuthorService;
import com.api.service.BookService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors(@RequestParam(name="fName", required=false) String fName){
        if(fName == null){
            return authorService.getAllAuthors();
        }else{
            return authorService.findByfNameContaining(fName);
        }
        
    }

    @PostMapping()
    public Author saveAuthor(@RequestBody Author author){
        return authorService.saveAuthor(author);
    }
}
