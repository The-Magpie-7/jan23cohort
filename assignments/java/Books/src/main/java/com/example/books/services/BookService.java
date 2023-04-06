package com.example.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.books.models.Book;
import com.example.books.repositories.BookRepository;

@Service
public class BookService {
	//inject repository - repository instance (will call the methods that are in the repository)
	private final BookRepository bookRepository;
	
	//dependency injection
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	//methods
	 // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
    	//from CrudRepository
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    
    //STUFF THAT I DID - Did I do it right?
    
    //update a book
    //have to use the setter methods from the domain model and then call the save method
    public Book updateBook(Book b) {
    	
    	Book updateBook = bookRepository.save(b);
    	return updateBook;
    }
    
    
    //delete a book
    //have to use the deleteById method
	public void deleteBook(Long id) {
		if(id != null) {
			bookRepository.deleteById(id);
		}
	}
	
}
