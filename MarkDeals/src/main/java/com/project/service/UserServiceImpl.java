package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.UserException;
import com.project.model.Cart;
import com.project.model.Users;
import com.project.model.UsersLogin;
import com.project.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Users registerUser(Users user) throws UserException {
		user.setCart(new Cart());
		String password = user.getPassword();
	    Integer key = 13;
		String encryptPassword = "";

		char[] charArray = password.toCharArray();
	
		for (char c : charArray) {
			c += key;
			encryptPassword += c;
		}
		user.setPassword(encryptPassword);
		return userRepository.save(user);
	}

	@Override
	public Users getUserDetailsByEmail(String email) throws UserException {
		Users existingUser = userRepository.findByUserEmail(email);
		if (existingUser == null) {
			throw new UserException("User does not exist with email " + email);
		}
		else {
			return existingUser;
		}
			
	}

	@Override
	public List<Users> getAllUserDetails() throws UserException {
		List<Users> users = userRepository.findAll();
		if (users == null) {
			throw new UserException("No user found");
		}
		return users;
	}

	@Override
	public Users userLogin(UsersLogin usersLogin) throws UserException {
		Users existingUsers = userRepository.findByUserEmail(usersLogin.getUserEmail());
		String password = usersLogin.getPassword();
	    Integer key = 13;
		String becryptPassword = "";

		char[] charArray = password.toCharArray();
	
		for (char c : charArray) {
			c += key;
			becryptPassword += c;
		}
		if (existingUsers.getPassword().equals(becryptPassword)) {
			return existingUsers;
		}
		throw new UserException("Wrong Credential");
		
	}

	@Override
	public Integer totalUsers() {
		List<Users> listOfUsers = userRepository.findAll();
		Integer totalUsersCounter = 0;
		for (Users users : listOfUsers) {
			totalUsersCounter++;
		}
		return totalUsersCounter;
	}

}
