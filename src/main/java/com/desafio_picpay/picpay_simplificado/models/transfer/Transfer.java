package com.desafio_picpay.picpay_simplificado.models.transfer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="Transfers")
@Entity
public class Transfer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="value")
	private double value;
	
	@Column(name="id_payer")
	private Long payer;
	
	@Column(name="id_payee")
	private Long payee;

	public Transfer(double value, Long payer, Long payee) {
		super();
		this.value = value;
		this.payer = payer;
		this.payee = payee;
	}

	public Transfer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
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
