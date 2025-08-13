package com.desafio_picpay.picpay_simplificado.enums;

public enum UserType {
	COMMON("common"),
	MERCHANT("merchant");
	
	private String userType;
	
	UserType(String userType){
		this.userType = userType;
	}
	
	public String getUserType() {
		return this.userType;
	}
}
