package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok(userService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") int id) {
		Optional<User> optional = userService.getById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<User> findByUsername(@PathVariable("username") String username) {
		Optional<User> optional = userService.findByUsername(username);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public ResponseEntity<User> update(@RequestBody User user) {
		if(user.getId() == 0) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(userService.update(user));
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user) {
		if(user.getId() != 0) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(userService.create(user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		userService.delete(id);
		
		return ResponseEntity.ok().build();
	}
}
