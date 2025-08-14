package com.desafio_picpay.picpay_simplificado.models.deposite;

import java.math.BigDecimal;

import jakarta.validation.constraints.Positive;

public class DepositeDTO {
	
	private Long userId;
	@Positive(message = "value must be positive.")
	private BigDecimal value;
	
	public DepositeDTO(Long userId, BigDecimal value) {
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

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	} 
}
