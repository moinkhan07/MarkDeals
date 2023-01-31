package com.project.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@NotNull(message = "First name should not be null")
	@Size(min = 3,max = 15,message = "Name should be between 3 to 15 characters")
	private String firstName;
	@NotNull(message = "Last name should not be null")
	@Size(min = 3,max = 12,message = "Name should be between 3 to 12 characters")
	private String lastName;
	@NotNull(message = "Email should not be null")
	@Email(message = "Please enter correct format of email")
	private String userEmail;
	@NotNull(message = "Password should not be null")
	@Size(min = 8,max = 20,message = "Password length should be between 8 to 20")
	private String password;
	@NotNull(message = "Mobile number should not be null")
	@Size(min = 10,max = 10,message = "Mobile number should be of 10 digits")
	private String userMobile;
	
	@Embedded
	private Address address;
	
	
	
}
