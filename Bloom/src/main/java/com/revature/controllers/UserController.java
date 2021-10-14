package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.User;
import com.revature.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String getHomePage() {
		return "home";
	}
	
	@ResponseBody
	@GetMapping("/user")
	public ResponseEntity<User> getUser() {
		return ResponseEntity.ok(User.builder()
				.id(2)
				.email("harry@hogwarts.com")
				.password("ginny")
				.username("theboywholived")
				.build());
	}
}
