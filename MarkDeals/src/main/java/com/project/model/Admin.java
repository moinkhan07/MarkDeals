package com.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	
	@NotNull(message = "Name should not be null")
	private String adminName;
	
	@NotNull(message = "email should not be in proper format")
	@Email
	@Column(unique = true)
	private String adminEmail;
	
	@NotNull(message = "password should not be null")
//	@Size(min = 8,max = 20,message = "Password should be between 8 to 20")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String adminPassword;
	
	@Size(min = 10,max = 10,message = "Mobile number should be of 10 digits")
	private String mobileNo;
	
	@Embedded
	private Address address;

}
