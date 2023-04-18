package com.example.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bookclub.models.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findAll();
	
	//optional to prevent errors if email is not found
	Optional<User> findByEmail(String email);

}
