package com.example.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookclub.models.Book;
import com.example.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	//add methods: (example)
	//find all (read)
	public List<Book> allBooks(){
		return bookRepository.findAll();	
	}
	
	//create
	public Book createOne(Book b) {
		return bookRepository.save(b);
	}
	
	//update
	public Book updateOne(Book b) {
		return bookRepository.save(b);
	}
	
	//read one
	public Book getOne(Long id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	//delete
	public void deleteOne(Long id) {
		bookRepository.deleteById(id);
	}
}
