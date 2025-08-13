package com.desafio_picpay.picpay_simplificado.models.user;

import com.desafio_picpay.picpay_simplificado.enums.UserType;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserDTO {

	private String name;
	
	@Size(min=11, max = 11, message="the length must to be 11")
	private String cpf;
	
	@Email
	private String email;
	
	private String password;
	
	private UserType userType;
	
	public UserDTO(String name, String cpf, String email, String password,
			UserType userType) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}

	public User cast() {
		User user = new User(this.name, this.cpf, this.email, this.password, this.userType);
		
		return user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
