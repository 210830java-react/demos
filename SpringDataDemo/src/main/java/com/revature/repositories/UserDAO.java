package com.revature.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.User;

public interface UserDAO extends JpaRepository<User, Integer> {

	public Optional<User> findByUsername(String username);
	// method2
	public Optional<User> findByEmail(String email);
}
