package com.example.loginandregistration.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.loginandregistration.models.LoginUser;
import com.example.loginandregistration.models.User;
import com.example.loginandregistration.repositories.UserRepository;


@Service
public class UserService {

	 @Autowired
	    private UserRepository userRepo;
	    
	    
	    //getOne
	  	//read one
	  	public User getOne(Long id) {
	  		return userRepo.findById(id).orElse(null);
	  	}
	    
	    //getAll
		public List<User> allContacts(){
			return userRepo.findAll();	
		}
		
	    
	    
	    //registration - Create
	    
	    public User register(User newUser, BindingResult result) {
	        if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
	            result.rejectValue("email", "Unique", "This email is already in use!");
	        }
	        if(!newUser.getPassword().equals(newUser.getConfirmPassword())) {
	            result.rejectValue("confirmPassword", "Matches", "The Confirm Password must match Password!");
	        }
	        if(result.hasErrors()) {
	            return null;
	        } else {
	            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	            newUser.setPassword(hashed);
	            return userRepo.save(newUser);
	        }
	    }
	    
	    
	    //login
	    
	    public User login(LoginUser newLogin, BindingResult result) {
	    	//check if email is found
	        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
	        if(!potentialUser.isPresent()) {
	            result.rejectValue("email", "Unique", "Unknown email!");
	            return null;
	        }
	        User user = potentialUser.get();
	        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	            result.rejectValue("password", "Matches", "Invalid Password!");
	        }
	        if(result.hasErrors()) {
	            return null;
	        } else {
	            return user;
	        }
	    }
}
