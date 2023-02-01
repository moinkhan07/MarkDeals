package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.AdminException;
import com.project.model.Admin;
import com.project.service.AdminService;

import jakarta.validation.Valid;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/admins")
	public ResponseEntity<Admin> registerAdmin( @RequestBody Admin admin) throws AdminException{
		admin.setAdminPassword(passwordEncoder.encode(admin.getAdminPassword()));
		Admin registerAdmin = adminService.registerUser(admin);
		return new ResponseEntity<>(registerAdmin,HttpStatus.CREATED);
	}
	
}
