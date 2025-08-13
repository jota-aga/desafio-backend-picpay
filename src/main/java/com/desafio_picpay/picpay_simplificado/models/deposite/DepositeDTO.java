package com.desafio_picpay.picpay_simplificado.models.deposite;

import jakarta.validation.constraints.Positive;

public class DepositeDTO {
	
	private Long userId;
	@Positive(message = "value must be positive.")
	private double value;
	
	public DepositeDTO(Long userId, double value) {
		super();
		this.userId = userId;
		this.value = value;
	}

	public DepositeDTO() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	} 
}
