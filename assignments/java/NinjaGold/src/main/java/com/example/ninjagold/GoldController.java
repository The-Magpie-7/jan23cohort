package com.example.ninjagold;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoldController {

	
	@RequestMapping("/")
	public String index(HttpSession session) {
		//count variable to start gold count
		int count = 0;
		//create arrayList of activities
		ArrayList<String> activities = new ArrayList<String>();
		
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", count);
			
			session.setAttribute("activity", activities);
			System.out.println("from requestmapping: " + count);
		}
		return "index.jsp";
	}
	
	
	
	@PostMapping("/gold/{place}")
	public String gold(HttpSession session, @PathVariable String place, Model model) {
		//getting current session value for count
		int count = (int) session.getAttribute("count");
		
		//format date time for activities
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = currentDateTime.format(formatter);

        
        //array list for activities 
        ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activity");
		
        //variable to hold random number for obtaining or loosing gold
		int randNum = 0;
		
		//test print
		System.out.println("from post, time : " + time + " " + count);
		
		if(place.equals("farm")) {
		
			//creating random number
			randNum = 10 + (int) (Math.random() * 20);
			
			//increasing count when clicked
			count += randNum;
			
			//test print
			System.out.println("from post in if farm: " + count);
			
			activities.add(0, "\n Entered farm, earned " + randNum + " gold. At " + time);
			session.setAttribute("activity", activities);
		
		}
		if(place.equals("cave")) {
			//creating random number
			randNum = 5 + (int) (Math.random() * 5);
			
			//increasing count when clicked
			count += randNum;
			
			System.out.println("from post in if cave: " + count);
			
			activities.add(0, "\n Entered cave, earned " + randNum + " gold. At " + time);
			session.setAttribute("activity", activities);
		}
		if(place.equals("house")) {
			//creating random number
			randNum = 2 + (int) (Math.random() * 20);
			
			//increasing count when clicked
			count += randNum;
			
			System.out.println("from post in if house: " + count);
			
			activities.add(0, "\n Entered house, earned " + randNum + " gold. At " + time);
			session.setAttribute("activity", activities);
		}
		if(place.equals("quest")) {
			//creating random number
			randNum = 50 - (int) (Math.random() * 100);
			
			//increasing count when clicked
			count += randNum;
			
			if(randNum < 0) {
				activities.add(0, "\n Took a quest, lost " + randNum + " gold. At " + time);
				session.setAttribute("activity", activities);
			}
			else { 
				activities.add(0, "\n Took a quest, earned " + randNum + " gold. At " + time);
				session.setAttribute("activity", activities);
			}
			
			System.out.println("from post in if quest: " + count);
		}
		
		//updating session - count variable
		session.setAttribute("count", count);
		
		session.setAttribute("earned", randNum);
		
		
		return "redirect:/";

	}

}
