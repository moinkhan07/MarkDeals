package com.project.service;

import java.util.List;

import com.project.exception.UserException;
import com.project.model.Users;

public interface UserService {
	
	public Users registerUser(Users user) throws UserException;
	
	public Users getUserDetailsByEmail(String email) throws UserException;
	
	public List<Users> getAllUserDetails() throws UserException;

}
