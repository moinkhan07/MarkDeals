package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Users;
import com.project.repository.UserRepository;

@RestController
public class UserLoginController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/signIn")
	public ResponseEntity<Users> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		Users users = userRepository.findByUserEmail(auth.getName());
		if (users == null) {
			throw new BadCredentialsException("Invalid Username or password");
		}
		 return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
		
		
	}

}
