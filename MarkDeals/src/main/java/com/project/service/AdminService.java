package com.project.service;

import com.project.exception.AdminException;
import com.project.model.Admin;
import com.project.model.AdminLoginDto;

public interface AdminService {
	
	public String addAdmin(Admin admin) throws AdminException;
	
	public String loginAdmin(AdminLoginDto adminLoginDto) throws AdminException;

}
