package com.kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.serviceImpl.TuneHubServiceImpl;

@Controller
public class UserController {
	@Autowired
	TuneHubServiceImpl serviceImpl;

	@PostMapping("/register")
	public String addUser(@ModelAttribute User user)
	{
		//email taken from registration form
		String email = user.getEmail();

		//checking if the email as entered in registration form
		//is present in DB or not
		boolean status = serviceImpl.emailExists(email);

		if(status == false) {
			serviceImpl.addUser(user);
			System.out.println("user added");			 
		}else {
			System.out.println("user added successfully");
		}
		return "Home";
	}
	@GetMapping("/validate")
	public String validate(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		if(serviceImpl.validateUser(email,password)== true){
			String role = serviceImpl.getRole(email);
			
			if(role.equals("admin")) {
				return "adminhome";
			}else {
				return "customerhome";
			}
		}
		else {
			return "login";
		}
	}
}