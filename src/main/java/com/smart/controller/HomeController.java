package com.smart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.dao.UserRepository;
import com.smart.entities.Users;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository rep;
	
	@Autowired
	PasswordEncoder password;
	
	@RequestMapping("/")
	public String tes1t(Model model ) {
		
//		Users user1= new Users();
//		user1.setName("Nishant ");
//		user1.setEmail("nishant123@gmail.com");
		model.addAttribute("title" , "Hi Nishant");
		
		//rep.save(user1);
		
		return "home";
	}
	
	
	@RequestMapping("/about")
	public String about(Model model ) {
		
//		Users user1= new Users();
//		user1.setName("Nishant ");
//		user1.setEmail("nishant123@gmail.com");
		model.addAttribute("title" , "Hi Nishant2");
		
		//rep.save(user1);
		
		return "about";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model ) {
		
		Users user1= new Users();
	//user1.setName("Nishant ");
	//user1.setEmail("nishant123@gmail.com");
		user1.setRole("ROLE_USER");
		user1.setEnabled(true);
		user1.setUrl("default.png");
		
		
		user1.setPassword(password.encode(user1.getPassword()));
		
	
	
		model.addAttribute("title" , "Please Registers");
		model.addAttribute("user" , new Users());
		
		//rep.save(user1);
		
		return "signup";
	}
	
	//THIS IS THE HANDLER FOR REGISTRING USER
	@PostMapping("/do_register")
	public String registerUser(@Valid @ModelAttribute("user") Users user) {
		System.out.println("USERHERE  "+user);
		rep.save(user);
		return "signup";
	}

}
