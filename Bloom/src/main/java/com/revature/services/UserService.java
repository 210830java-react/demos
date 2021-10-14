package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repositories.UserDAO;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;
}
