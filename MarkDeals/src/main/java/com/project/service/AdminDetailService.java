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

import com.project.model.Admin;
import com.project.repository.AdminRepository;
@Service
public class AdminDetailService implements UserDetailsService{

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin existingAdmin = adminRepository.findByAdminEmail(username);
		if (existingAdmin != null) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			return new User(existingAdmin.getAdminEmail(), existingAdmin.getAdminPassword(), authorities);
		}
		throw new BadCredentialsException("Admin Details not found with this username: " + username);
	}

}
