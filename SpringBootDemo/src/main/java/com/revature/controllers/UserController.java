package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping
	public ResponseEntity<User> getSingleUser() {
		return ResponseEntity.ok(
				User.builder()
					.id(1)
					.email("harry@hogwarts.com")
					.username("harry")
					.password("ginny")
					.build());
	}
}
