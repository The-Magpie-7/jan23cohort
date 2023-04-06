package com.example.burgertracker1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.burgertracker1.models.Burger;
import com.example.burgertracker1.repositories.BurgerRepository;

@Service
public class BurgerService {

	@Autowired
	private BurgerRepository burgerRepository;
	
	
	//CRUD METHODS 
	//find all (read)
	public List<Burger> allBurgers(){
		return burgerRepository.findAll();	
	}
		

	//create
	public Burger createOne(Burger b) {
		return burgerRepository.save(b);
	}
	//update
	public Burger updateOne(Burger b) {
		return burgerRepository.save(b);
	}
	//read one
	public Burger getOne(Long id) {
		return burgerRepository.findById(id).orElse(null);
	}
	//delete
	public void deleteOne(Long id) {
		burgerRepository.deleteById(id);
	}
}
