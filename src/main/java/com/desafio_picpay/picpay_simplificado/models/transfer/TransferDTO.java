package com.desafio_picpay.picpay_simplificado.models.transfer;

import java.math.BigDecimal;

import jakarta.validation.constraints.Positive;

public class TransferDTO {
	@Positive(message = "value must be positive.")
	private BigDecimal value;
	
	private Long payer;
	
	private Long payee;

	public TransferDTO(@Positive BigDecimal value, Long payer, Long payee) {
		super();
		this.value = value;
		this.payer = payer;
		this.payee = payee;
	}
	
	public Transfer cast() {
		Transfer transfer = new Transfer(this.value, this.payer, this.payee);
		
		return transfer;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Long getPayer() {
		return payer;
	}

	public void setPayer(Long payer) {
		this.payer = payer;
	}

	public Long getPayee() {
		return payee;
	}

	public void setPayee(Long payee) {
		this.payee = payee;
	}
}
