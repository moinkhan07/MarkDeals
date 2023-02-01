package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	public Admin findByAdminEmail(String adminEmail);

}
