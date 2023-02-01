package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.AdminException;
import com.project.model.Admin;
import com.project.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public Admin registerUser(Admin admin) throws AdminException {
		return adminRepository.save(admin);
	}

	@Override
	public Admin getAdminDetailsByEmail(String email) throws AdminException {
		Admin existingAdmin = adminRepository.findByAdminEmail(email);
		if (existingAdmin == null) {
			throw new AdminException("Admin does not exist with email id " + email);
		}
		return existingAdmin;
	}
	
	

}
