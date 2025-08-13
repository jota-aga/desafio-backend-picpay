package com.desafio_picpay.picpay_simplificado.models.user;

import com.desafio_picpay.picpay_simplificado.enums.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="Users")
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="cpf", unique = true)
	private String cpf;
	
	@Column(name="email", unique = true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="balance")
	private double balance;
	
	@Column(name="user_type")
	private UserType userType;
	
	public User() {
		super();
	}

	public User(String name, String cpf, String email, String password, UserType userType) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
		this.userType = userType;
		this.balance = 0;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
