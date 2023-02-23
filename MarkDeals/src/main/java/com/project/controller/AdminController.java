package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.AdminException;
import com.project.model.Admin;
import com.project.model.AdminLoginDto;
import com.project.service.AdminService;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admins")
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin) throws AdminException{
		String result = adminService.addAdmin(admin);
		return new ResponseEntity<String>(result,HttpStatus.CREATED);
	}

	@PostMapping("/admins")
	public ResponseEntity<Admin> loginAdmin(@RequestBody AdminLoginDto adminLoginDto) throws AdminException{
		Admin result = adminService.loginAdmin(adminLoginDto);
		return new ResponseEntity<>(result,HttpStatus.OK);
 	}
	
	
}
