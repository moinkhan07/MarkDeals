package com.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Users {

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
	@Column(unique = true)
	private String userEmail;
	
	@NotNull(message = "Password should not be null")
	@Size(min = 8,max = 20,message = "Password length should be between 8 to 20")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@NotNull(message = "Mobile number should not be null")
	@Size(min = 10,max = 10,message = "Mobile number should be of 10 digits")
	private String userMobile;
	
	@Embedded
	@Valid
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
	private Cart cart;
}
