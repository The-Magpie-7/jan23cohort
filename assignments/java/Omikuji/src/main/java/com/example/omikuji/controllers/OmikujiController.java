package com.example.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	
	@RequestMapping("omikuji")
	public String omikuji(){
		
		return "Welcome!";
	}
	
	@RequestMapping("omikuji/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping("omikuji/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping("omikuji/lotto/{number}")
	public String lotto(@PathVariable("number") int number) {
		if(number %2 ==0) {
			//number is even - divisible by 2
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}
		//number is odd - not divisible by 2
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family an friends.";
	}
	
	//accept path variables
	@RequestMapping("omikuji/travel/{city}")
	public String travel(@PathVariable("city") String city) {
		return "Congratulations! You will soon travel to " + city + "!";
	}
	
	//A route to render the home page that shows the Omikuji form
	@RequestMapping("/")
	public String index(){

		return "index.jsp";
	}
	
	//A POST route to process the form when the user hits "send"
	@PostMapping("/makeFortune")
	public String makeFortune(@RequestParam("number") int number, @RequestParam("city") String city, @RequestParam("name") String name, @RequestParam("hobby") String hobby, @RequestParam("thing") String thing, @RequestParam("say") String say, HttpSession session) {
	session.setAttribute("number", number);
	session.setAttribute("city", city);
	session.setAttribute("name", name);
	session.setAttribute("hobby", hobby);
	session.setAttribute("thing", thing);	
	session.setAttribute("say", say);
	//always use a redirect: at end of a post
	return "redirect:/show";
}
	
	//A route to render their fortune
	@GetMapping("/show")
	public String show(Model model, HttpSession session ) {
		int number = (int)session.getAttribute("number");
		String city = (String)session.getAttribute("city");
		String name = (String)session.getAttribute("name");
		String hobby = (String)session.getAttribute("hobby");
		String thing = (String)session.getAttribute("thing");
		String say = (String)session.getAttribute("say");
		
		model.addAttribute("number", number);
		model.addAttribute("city", city);
		model.addAttribute("name", name);
		model.addAttribute("hobby", hobby);
		model.addAttribute("thing", thing);
		model.addAttribute("say", say);
		return "show.jsp";
	}

}
