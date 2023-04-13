package com.example.dojoandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojoandninjas.models.Dojo;
import com.example.dojoandninjas.models.Ninja;
import com.example.dojoandninjas.services.DojoService;
import com.example.dojoandninjas.services.NinjaService;

@Controller
public class HomeController {

	@Autowired
	private NinjaService ninjaService;
	
	@Autowired
	private DojoService dojoService;
	
	
	@GetMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	
	
	//--------------
	// DOJOS
	//--------------
	
	//get form to add a new Dojo
	@GetMapping("newDojo")
	public String newDojo(@ModelAttribute("dojoForm") Dojo dojo, Model model){
		
		//list of dojos
		List<Dojo> dojos = dojoService.allDojos();
		
		//for model attribute
		model.addAttribute("dojos", dojos);
		
		return "newDojo.jsp";
	}
	
	//create/save new Dojo
	@PostMapping("createDojo")
	public String createDojo(@Valid @ModelAttribute("dojoForm") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			//errors on form - return to newDojo
			return "/newDojo.jsp";
		}
		//list of dojos
		List<Dojo> dojos = dojoService.allDojos();
		
		//for model attribute - for viewDojos
		model.addAttribute("dojos", dojo);
		dojoService.createOne(dojo);
		//Long theId = dojo.getId();
		return "redirect:/viewDojo/" + dojo.getId();
	}
	
	
	//--------------------
	// NINJA
	//--------------------
	
	//get form to add new Ninja
	@GetMapping("newNinja")
	public String newNinja(@ModelAttribute("ninjaForm") Ninja ninja, Model model) {
		//list of dojos for dropdown select on form
		model.addAttribute("allDojos", dojoService.allDojos());
		return "newNinja.jsp";
	}
	
	
	//create/save new Ninja
	@PostMapping("createNinja")
	public String createNinja(@Valid @ModelAttribute("ninjaForm") Ninja ninja, BindingResult result, Model model) {
		System.out.println("got to createNinja --"  + "  **************");
		if(result.hasErrors()) {
			//errors on form - return to newDojo with the list of dojos
			model.addAttribute("allDojos", dojoService.allDojos());
			return "newNinja.jsp";
		}

		ninjaService.createOne(ninja);
		
		return "redirect:/viewDojo" + ninja.getDojo().getId();
	}
	
	//--------------------
	// Dojo and Ninjas
	//--------------------
	
	//display all the ninjas in one dojo
	@GetMapping("viewDojo/{id}")
	public String viewDojo(@PathVariable Long id, Model model) {
		model.addAttribute("allNinjas", ninjaService.allNinjas());
		model.addAttribute("dojo", dojoService.getOne(id));
		return "viewDojo.jsp";
	}
	
}
