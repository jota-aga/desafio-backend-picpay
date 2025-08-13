package com.desafio_picpay.picpay_simplificado.exceptions;

public class MerchantCantTransferException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MerchantCantTransferException() {
		super("Merchant cant transfer.");
	}
}
