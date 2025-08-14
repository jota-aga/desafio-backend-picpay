package com.desafio_picpay.picpay_simplificado.service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.desafio_picpay.picpay_simplificado.enums.UserType;
import com.desafio_picpay.picpay_simplificado.exceptions.BalanceIsNotEnoughException;
import com.desafio_picpay.picpay_simplificado.exceptions.MerchantCantTransferException;
import com.desafio_picpay.picpay_simplificado.exceptions.TransferNotAuthorizedException;
import com.desafio_picpay.picpay_simplificado.exceptions.UserNotFoundException;
import com.desafio_picpay.picpay_simplificado.models.transfer.Transfer;
import com.desafio_picpay.picpay_simplificado.models.user.User;
import com.desafio_picpay.picpay_simplificado.repository.TransferRepository;

@Service
public class TransferService {
	
	@Autowired
	TransferRepository repo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RestTemplate restTemplate;
	
	public void saveTransfer(Transfer transfer) throws MerchantCantTransferException, BalanceIsNotEnoughException, UserNotFoundException, TransferNotAuthorizedException {
		User payer = userService.findById(transfer.getPayer());
		User payee = userService.findById(transfer.getPayee());
			
		if(payer.getBalance().compareTo(transfer.getValue()) == -1) {
			throw new BalanceIsNotEnoughException();
		}
			
		if(payer.getUserType() == UserType.MERCHANT) {
			throw new MerchantCantTransferException();
		}
		
		boolean authorization = authorizeTransfer();
		
		if(authorization == false){
			throw new TransferNotAuthorizedException();
		}
			
		payer.setBalance(payer.getBalance().subtract(transfer.getValue()));
		payee.setBalance(payee.getBalance().add(transfer.getValue()));
		userService.saveUser(payer);
		userService.saveUser(payee);
		repo.save(transfer);
	}
	
	public boolean authorizeTransfer() {
		ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://util.devi.tools/api/v2/authorize", Map.class);
		
		if(authorizationResponse.getStatusCode() == HttpStatus.OK) {
			return true;
		}
		else {
			return false;
		}
	}
}
