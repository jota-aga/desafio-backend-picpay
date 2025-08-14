package com.desafio_picpay.picpay_simplificado.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio_picpay.picpay_simplificado.exceptions.UserNotFoundException;
import com.desafio_picpay.picpay_simplificado.models.deposite.DepositeDTO;
import com.desafio_picpay.picpay_simplificado.models.user.User;
import com.desafio_picpay.picpay_simplificado.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public void saveUser(User user) {
		repo.save(user);
	}
	
	public User findById(Long id) throws UserNotFoundException {
		Optional<User> user = repo.findById(id);
		
		if(user.isPresent()) {
			return user.get();
		}
		else {
			throw new UserNotFoundException();
		}
			
	}
	
	public void depositeToBalance(DepositeDTO depositeDto) throws UserNotFoundException {
		User user = findById(depositeDto.getUserId());
		
		BigDecimal totalBalance = user.getBalance().add(depositeDto.getValue());
		
		user.setBalance(totalBalance);
		repo.save(user);
	}
}
