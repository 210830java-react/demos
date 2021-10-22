package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@ConfigurationProperties
public class MessageController {
	
	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@GetMapping
	public String getMessage() {
		return message;
	}
}
