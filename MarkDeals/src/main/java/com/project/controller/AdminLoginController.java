package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Admin;
import com.project.repository.AdminRepository;

@RestController
public class AdminLoginController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@GetMapping("/login")
	public ResponseEntity<Admin> getLoggedInAdminDetailsHandler(Authentication auth){
		
		Admin admin = adminRepository.findByAdminEmail(auth.getName());
		if (admin == null) {
			throw new BadCredentialsException("Invalid Username or password");
		}
		 return new ResponseEntity<>(admin, HttpStatus.ACCEPTED);
	}

}
