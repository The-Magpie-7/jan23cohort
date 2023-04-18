package com.example.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bookclub.models.LoginUser;
import com.example.bookclub.models.User;
import com.example.bookclub.services.BookService;
import com.example.bookclub.services.UserService;


@Controller
public class UserController {

	//autowire all the services
	//ensure services are implemented
	@Autowired
	private UserService userServ;
	
	@Autowired
	private BookService bookService;
	
		
		
	//---------------------------
	// Login and Registration
	//---------------------------
 	
    @GetMapping("/")
    public String index(HttpSession session, @ModelAttribute("newUser") User newUser, Model model) {
		//check if user is in session
    	if(session.getAttribute("user_id") != null) {
    		return "redirect:/";
    	}
    	else {
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
    		return "index.jsp";
    	}
    }
		
//		@GetMapping("/logReg")
//	    public String logReg(HttpSession session, @ModelAttribute("newUser") User newUser, Model model) {
//			//check if user is in session
//	    	if(session.getAttribute("user_id") != null) {
//	    		return "redirect:/";
//	    	}
//	    	else {
//		        model.addAttribute("newUser", new User());
//		        model.addAttribute("newLogin", new LoginUser());
//	    		return "index.jsp";
//	    	}
//	    }
	    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    	// call a register method in the service
    	 // - extra validations included in the service
    	userServ.register(newUser, result);
       
    	if(result.hasErrors()) {
    		//there are errors, do not log in
    		//send empty LoginUser to re-render page
    		model.addAttribute("newLogin", new LoginUser());
    		return "index.jsp";
    	}
    	//no errors!     
    	//Store id in session & log user in
    	session.setAttribute("user_id", newUser.getId());
    	return "redirect:/welcome";
    }
        
   
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
        // No errors! 
        // Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", user.getId());
        return "redirect:/welcome";
    }
    
    // Logout User
 	@GetMapping("/logout")
 	public String logout(HttpSession session) {
 		session.invalidate();
 		return "redirect:/";
 	}
 	
// 	//welcome pg for users to go to when they login
// 	@GetMapping("/welcome")
// 	public String welcome(HttpSession session, Model model) {
// 		if(session.getAttribute("user_id") == null) {
// 			return "redirect:/";
// 		}
// 		else {
// 			//get the user id for session
// 			model.addAttribute("theUser", userServ.getOne((Long)session.getAttribute("user_id")));
// 			return "welcome.jsp";
// 		}
// 	}
}
