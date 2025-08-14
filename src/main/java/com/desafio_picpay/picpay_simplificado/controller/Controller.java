package com.desafio_picpay.picpay_simplificado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desafio_picpay.picpay_simplificado.exceptions.BalanceIsNotEnoughException;
import com.desafio_picpay.picpay_simplificado.exceptions.MerchantCantTransferException;
import com.desafio_picpay.picpay_simplificado.exceptions.TransferNotAuthorizedException;
import com.desafio_picpay.picpay_simplificado.exceptions.UserNotFoundException;
import com.desafio_picpay.picpay_simplificado.models.deposite.DepositeDTO;
import com.desafio_picpay.picpay_simplificado.models.transfer.Transfer;
import com.desafio_picpay.picpay_simplificado.models.transfer.TransferDTO;
import com.desafio_picpay.picpay_simplificado.models.user.User;
import com.desafio_picpay.picpay_simplificado.models.user.UserDTO;
import com.desafio_picpay.picpay_simplificado.service.TransferService;
import com.desafio_picpay.picpay_simplificado.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("")
public class Controller {
	
	@Autowired
	UserService userService;
	
	@Autowired
	TransferService transferService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@Valid @RequestBody UserDTO userDTO){
		User user = userDTO.cast();
		userService.saveUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
	@PutMapping("/deposite")
	public ResponseEntity<String> deposite(@Valid @RequestBody DepositeDTO depositeDTO) throws UserNotFoundException{
		userService.depositeToBalance(depositeDTO);
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<String> transfer(@Valid @RequestBody TransferDTO transferDTO) throws MerchantCantTransferException, BalanceIsNotEnoughException, UserNotFoundException, TransferNotAuthorizedException{
		Transfer transfer =  transferDTO.cast();
		transferService.saveTransfer(transfer);
		
		return ResponseEntity.status(HttpStatus.OK).body(null);	
	}
}
