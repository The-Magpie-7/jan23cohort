package com.example.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.bookclub.models.Book;
import com.example.bookclub.services.BookService;
import com.example.bookclub.services.UserService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	//welcome pg for users to go to when they login
 	@GetMapping("/welcome")
 	public String welcome(HttpSession session, Model model) {
 		if(session.getAttribute("user_id") == null) {
 			return "redirect:/";
 		}
 		else {
 			//get the user id for session
 			model.addAttribute("theUser", userService.getOne((Long)session.getAttribute("user_id")));
 			//get the list of all the books to display
 			model.addAttribute("allBooks", bookService.allBooks());
 			return "welcome.jsp";
 		}
 	}
 	
 	//add a book to your shelf - gets the form
 	@GetMapping("addBook")
 	public String addBook(HttpSession session, @ModelAttribute("bookForm") Book book, Model model) {
 		if(session.getAttribute("user_id") == null) {
 			return "redirect:/index";
 		}
 		else {
 			return "addBook.jsp";
 		}
 	}
 	
 	//create the book in db
 	@PostMapping("createBook")
 	public String createBook(@Valid @ModelAttribute("bookForm") Book book, BindingResult result, Model model, HttpSession session){
 		if(result.hasErrors()) {
 			return "addBook.jsp";
 		}
 		else {
 			bookService.createOne(book);
 			return "redirect:/welcome";
 		}
 	}
 	
 	@GetMapping("/viewOne/{id}")
 	public String viewOne(HttpSession session,@PathVariable("id") Long id, Model model) {
 		if(session.getAttribute("user_id") == null) {
 			return "redirect:/";
 		}
 		else {
 			model.addAttribute("book", bookService.getOne(id));
 			return "viewOne.jsp";
 		}
 	}
 	
 	@GetMapping("editBook/{id}")
 	public String editBook(HttpSession session, @PathVariable("id") Long id, @ModelAttribute("bookEditForm") Book book, Model model) {
 		if(session.getAttribute("user_id") == null) {
 			return "redirect:/";
 		}
 		else {
 			model.addAttribute("book", bookService.getOne(id));
 			return "/editBook.jsp";
 		}
 	}
 	
 	@PutMapping("/updateBook/{id}")
 	public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("bookEditForm") Book editBook, BindingResult result, Model model) {
 		if(result.hasErrors()){
 			model.addAttribute("book", bookService.getOne(id));
 			return "editBook.jsp";
 		}
 		else {
 			bookService.updateOne(editBook);
 			return "redirect:/viewOne/" + editBook.getId();
 		}
 	}
 	
 	@PostMapping("/deleteBook/{id}")
 	public String destroy(@PathVariable("id") Long id) {
 		bookService.deleteOne(id);
 		return "redirect:/welcome";
 	}
 	
}//end of controller
