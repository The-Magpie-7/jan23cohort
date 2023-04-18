package com.example.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.example.savetravels.models.Expense;
import com.example.savetravels.services.ExpenseService;

@Controller
public class HomeController {
	
	//connect controller with service
	@Autowired
	private ExpenseService expenseService;

	
	@GetMapping("/")
	public String index(){
	
	//model.addAttribute("allExpenses", expenseService.allExpenses());
	
		return "index.jsp";
	}
	
	//gets and displays the add expense form
	@GetMapping("addExpense")
	public String addExpense(@ModelAttribute("addExpenseForm") Expense expense, Model model) {
		model.addAttribute("allExpenses", expenseService.allExpenses());
		
		return "addExpense.jsp";
	}
	
	//adds the data from the add expense form
	@PostMapping("/createExpense")
	public String createExpense(@Valid @ModelAttribute("addExpenseForm") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			//if there are validation errors, return user to add expense form
			return "addExpense.jsp";
		}
		else {
			//no validation errors, save the data in db
			expenseService.createOne(expense);
			return "redirect:/addExpense";
		}
	}
	
	//get form to edit expense
	@GetMapping("/expense/{id}/editExpense")
	public String editExpense(@PathVariable("id") Long id, @ModelAttribute("editExpenseForm") Expense expense, Model model) {
		model.addAttribute("expense", expenseService.getOne(id));
		return "editExpense.jsp";
	}
	
	//update & save the edited expense
	@PutMapping("/expense/{id}/update")
	public String updateExpense(@PathVariable("id") Long id, @Valid @ModelAttribute("editExpenseForm") Expense expense, BindingResult result, Model model){
		if(result.hasErrors()) {
			//pass in the id to keep it for editing 
			model.addAttribute("expense", expenseService.getOne(id));
			//return to edit pg due to errors
			return "editExpense.jsp";
		}
		else {
			//no errors/is valid, save expense changes
			//and return to main expense display
			expenseService.updateOne(expense);
			return "redirect:/addExpense";
		}
	}
	
	//delete an expense
	@DeleteMapping("/deleteExpense/{id}")
	public String deleteExpense(@PathVariable("id") Long id, @ModelAttribute("deleteForm") Expense expense) {
		expenseService.deleteOne(id);
		return "redirect:/addExpense";
	}

	 //view one expense
    @GetMapping("/expense/{id}/view")
    public String viewExpense(@PathVariable("id") Long id, @ModelAttribute("viewExpense") Expense expense, Model model) {

	    	model.addAttribute("expense", expenseService.getOne(id));
	    	return "viewExpense.jsp";
    }
}
