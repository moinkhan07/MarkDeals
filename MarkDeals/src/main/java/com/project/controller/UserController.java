package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.UserException;
import com.project.model.Users;
import com.project.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<Users> saveUsersHandler(@RequestBody Users users) throws UserException{
		
		Users registeredUser= userService.registerUser(users);
		
		return new ResponseEntity<>(registeredUser,HttpStatus.ACCEPTED);
		
	}
	
	
	
	@GetMapping("/users/{email}")
	public ResponseEntity<Users> getUserByEmailHandler(@PathVariable("email") String email) throws UserException{
		
		
		Users user = userService.getUserDetailsByEmail(email);
		
		return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
		
	}
	 
	@GetMapping("/users")
	public ResponseEntity<List<Users>> getAllUsersHandler() throws UserException{
		
		
		List<Users> users= userService.getAllUserDetails();
		
		return new ResponseEntity<>(users,HttpStatus.ACCEPTED);
		
	} 
	

}
