package com.desafio_picpay.picpay_simplificado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio_picpay.picpay_simplificado.models.transfer.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
