package com.project.service;

import com.project.exception.AdminException;
import com.project.model.Admin;

public interface AdminService {
	
    public Admin registerUser(Admin admin) throws AdminException;
	
	public Admin getAdminDetailsByEmail(String email) throws AdminException;
	
}
