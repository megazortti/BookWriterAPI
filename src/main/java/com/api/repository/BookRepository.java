package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.dto.BookAuthorDTO;
import com.api.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select new com.api.dto.BookAuthorDTO(b.title, a.fName || ':' || a.lName) from Book b join b.author a")
    List<BookAuthorDTO> findBookNamesAndAuthorNames();
}