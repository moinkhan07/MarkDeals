package com.project.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	@NotNull(message = "Name should not be null")
	private String adminName;
	@NotNull(message = "email should not be in proper format")
	@Email
	private String adminEmail;
	@NotNull(message = "password should not be null")
	@Size(min = 8,max = 20,message = "Password should be between 8 to 20")
	private String adminPassword;
	@Size(min = 10,max = 10,message = "Mobile number should be of 10 digits")
	private String MobileNo;
	
	@Embedded
	private Address address;

}
