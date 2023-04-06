package com.example.books.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.models.Book;
import com.example.books.services.BookService;

@RestController
public class BooksApi {
	private final BookService bookService;

	/**
	 * @param bookService
	 */
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	 @RequestMapping("/api/books")
	 public List<Book> index() {
	     return bookService.allBooks();
	 }
	 
	 @RequestMapping(value="/api/books", method=RequestMethod.POST)
	 public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	     Book book = new Book(title, desc, lang, numOfPages);
	     return bookService.createBook(book);
	 }
	 
	 @RequestMapping("/api/books/{id}")
	 public Book show(@PathVariable("id") Long id) {
	     Book book = bookService.findBook(id);
	     return book;
	 }
	
	 @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	 public Book update(
	 		@PathVariable("id") Long id, 
	 		@RequestParam(value="title") String title, 
	 		@RequestParam(value="description") String desc, 
	 		@RequestParam(value="language") String lang,
	 		@RequestParam(value="pages") Integer numOfPages) {
		 Book b = new Book(title, desc, lang, numOfPages);
		 b.setId(id);
	     //Book book = bookService.updateBook(b);
	     Book updatedBook = bookService.updateBook(b);
	     return updatedBook;
	 }
	 
	 @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	 public void destroy(@PathVariable("id") Long id) {
	     bookService.deleteBook(id);
	 }

}

