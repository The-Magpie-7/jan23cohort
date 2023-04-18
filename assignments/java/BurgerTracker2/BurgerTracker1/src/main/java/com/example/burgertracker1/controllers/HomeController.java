package com.example.burgertracker1.controllers;
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

import com.example.burgertracker1.models.Burger;
import com.example.burgertracker1.services.BurgerService;

@Controller
public class HomeController {

	@Autowired
	private BurgerService burgerService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("addBurger") Burger burger, Model model){
	
		model.addAttribute("allBurgers", burgerService.allBurgers());
	
		return "index.jsp";
	}
	
	//adding a burger
	@PostMapping("/createBurger")
	public String createBurger(@Valid @ModelAttribute("addBurger") Burger burger, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "/index.jsp";
		}
		burgerService.createOne(burger);
		return "redirect:/";
	}
	
	//edit a burger
	@GetMapping("/editBurger/{id}")
	public String editBurger(@PathVariable("id") Long id, @ModelAttribute("editBurgerForm") Burger burger, Model model) {
		model.addAttribute("burger", burgerService.getOne(id));
		
		return "editBurger.jsp";
	}
	
	//update/save the edited burger
	@PutMapping("/burger/{id}/update")
	public String updateBurger(@PathVariable("id") Long id, @Valid @ModelAttribute("editBurgerForm") Burger burger, BindingResult result, Model model) {
		if(result.hasErrors()) {
			//return due to errors
			return "editBurger.jsp";
		}
		else {
			burgerService.updateOne(burger);
			return "redirect:/";
		}
	}
	
}
