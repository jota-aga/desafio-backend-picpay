package com.desafio_picpay.picpay_simplificado.exceptions;

public class BalanceIsNotEnoughException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BalanceIsNotEnoughException() {
		super("Balance is not enough.");
	}
}
