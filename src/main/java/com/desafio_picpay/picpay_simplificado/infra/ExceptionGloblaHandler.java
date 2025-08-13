package com.desafio_picpay.picpay_simplificado.infra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.desafio_picpay.picpay_simplificado.exceptions.BalanceIsNotEnoughException;
import com.desafio_picpay.picpay_simplificado.exceptions.MerchantCantTransferException;
import com.desafio_picpay.picpay_simplificado.exceptions.UserNotFoundException;

@ControllerAdvice
public class ExceptionGloblaHandler{
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFoundExceptionHandler(UserNotFoundException e){
		String messageError = e.getMessage();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageError);
	}
	
	@ExceptionHandler(BalanceIsNotEnoughException.class)
	public ResponseEntity<String> balanceIsNotEnoughExceptionHandler(BalanceIsNotEnoughException e){
		String messageError = e.getMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageError);
	}
	
	@ExceptionHandler(MerchantCantTransferException.class)
	public ResponseEntity<String> merchantCantTransferHandler(MerchantCantTransferException e){
		String messageError = e.getMessage();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(messageError);
	}
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException e) {
	        Map<String, String> errors = new HashMap<>();
	        
	        e.getBindingResult().getAllErrors().forEach(error -> {
	            String fieldName = ((FieldError) error).getField();
	            String errorMessage = error.getDefaultMessage();
	            errors.put(fieldName, errorMessage);
	        });

	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	    }
}
