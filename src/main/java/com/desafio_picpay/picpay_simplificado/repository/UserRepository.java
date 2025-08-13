package com.desafio_picpay.picpay_simplificado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio_picpay.picpay_simplificado.models.user.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
