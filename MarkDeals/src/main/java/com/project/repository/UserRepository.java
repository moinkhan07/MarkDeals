package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	public Users findByUserEmail(String userEmail);

}
