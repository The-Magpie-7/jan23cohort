package com.example.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bookclub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	// this method retrieves all from the database
    List<Book> findAll();
}
