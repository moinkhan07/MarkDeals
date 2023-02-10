package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.UserException;
import com.project.model.Users;
import com.project.model.UsersLogin;
import com.project.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<Users> saveUsersHandler(@Valid @RequestBody Users users) throws UserException{
		
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
	
	
	@PostMapping("/userlogin")
	public ResponseEntity<Users> userLogin(@RequestBody UsersLogin usersLogin) throws UserException {
		Users result = userService.userLogin(usersLogin);
		return new ResponseEntity<Users>(result,HttpStatus.OK);
		
	}
	

}
