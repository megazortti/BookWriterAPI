package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByfNameContaining(String fName);
}
