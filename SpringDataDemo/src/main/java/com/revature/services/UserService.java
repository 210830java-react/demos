package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public List<User> getAll() {
		return userDAO.findAll();
	}
	
	public Optional<User> getById(int id) {
		return userDAO.findById(id);
	}
	
	public User create(User user) {
		return userDAO.save(user);
	}
	
	public User update(User user) {
		return userDAO.save(user);
	}
	
	public void delete(int id) {
		userDAO.deleteById(id);
	}
	
	public Optional<User> findByUsername(String username) {
		return userDAO.findByUsername(username);
	}
}
