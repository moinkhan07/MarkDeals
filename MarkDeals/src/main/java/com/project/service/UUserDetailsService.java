package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.model.Users;
import com.project.repository.UserRepository;

@Service
public class UUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users existingUser = userRepository.findByUserEmail(username);
		if (existingUser != null) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			return new User(existingUser.getUserEmail(), existingUser.getPassword(), authorities);
		}
		throw new BadCredentialsException("User Details not found with this username: " + username);
	}

}
