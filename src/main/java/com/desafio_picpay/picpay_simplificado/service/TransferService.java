package com.desafio_picpay.picpay_simplificado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio_picpay.picpay_simplificado.enums.UserType;
import com.desafio_picpay.picpay_simplificado.exceptions.BalanceIsNotEnoughException;
import com.desafio_picpay.picpay_simplificado.exceptions.MerchantCantTransferException;
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
	
	public void saveTransfer(Transfer transfer) throws MerchantCantTransferException, BalanceIsNotEnoughException, UserNotFoundException {
		User payer = userService.findById(transfer.getPayer());
		User payee = userService.findById(transfer.getPayee());
			
		if(payer.getBalance() < transfer.getValue()) {
			throw new BalanceIsNotEnoughException();
		}
			
		if(payer.getUserType() == UserType.MERCHANT) {
			throw new MerchantCantTransferException();
		}
			
		payer.setBalance(payer.getBalance() - transfer.getValue());
		payee.setBalance(payee.getBalance() + transfer.getValue());
		userService.saveUser(payer);
		userService.saveUser(payee);
		repo.save(transfer);
	}
}
