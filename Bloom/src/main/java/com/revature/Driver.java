package com.revature;

import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {
		
		// Test out that Lombok properly generated methods for us
		User larry = new User(1, "larry", "password", "larry@gmail.com");

		System.out.println(larry.getEmail());
		
		User harry = User.builder()
				.id(2)
				.email("harry@hogwarts.com")
				.password("ginny")
				.username("theboywholived")
				.build();
		
		System.out.println(harry);
	}

}
