package com.example.savetravels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.savetravels.models.Expense;
import com.example.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	//connect service to repo
	@Autowired
	private ExpenseRepository expenseRepository;

	
		//add CRUD methods:
		//find all (read)
		public List<Expense> allExpenses(){
			return expenseRepository.findAll();	
		}
		

		//create
		public Expense createOne(Expense e) {
			return expenseRepository.save(e);
		}
		
		//update
		public Expense updateOne(Expense e) {
			return expenseRepository.save(e);
		}
		  
		  //read one
		public Expense getOne(Long id) { return
		  expenseRepository.findById(id).orElse(null);
		}
		  
		//delete
		public void deleteOne(Long id) {
			expenseRepository.deleteById(id);
		}
		 
}
