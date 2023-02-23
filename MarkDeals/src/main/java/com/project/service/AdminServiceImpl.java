package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.AdminException;
import com.project.model.Admin;
import com.project.model.AdminLoginDto;
import com.project.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public String addAdmin(Admin admin) throws AdminException {
		Admin existingAdmin = adminRepository.findByEmail(admin.getEmail());
		if (existingAdmin != null) {
			throw new AdminException("Already admin exist with username " + admin.getEmail());
		}
		adminRepository.save(admin);
		return "Admin save successfully";
	}

	@Override
	public Admin loginAdmin(AdminLoginDto adminLoginDto) throws AdminException {
		Admin existingAdmin = adminRepository.findByEmail(adminLoginDto.getEmail());
        
		if (existingAdmin.getPassword().equals(adminLoginDto.getPassword())) {
			return existingAdmin;
		}
		throw new AdminException("Wrong Credential"); 
	}

}
