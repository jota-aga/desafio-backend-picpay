package com.desafio_picpay.picpay_simplificado.exceptions;

public class TransferNotAuthorizedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TransferNotAuthorizedException() {
		super("Transfer Not Authorized.");
	}

}
