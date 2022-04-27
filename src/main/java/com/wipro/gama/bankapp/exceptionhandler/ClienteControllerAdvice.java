package com.wipro.gama.bankapp.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "com.wipro.gama.bankapp.controller")
public class ClienteControllerAdvice {

	
	@ResponseBody
	@ExceptionHandler(ClienteNotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> productNotFound(ClienteNotFoundException clienteNotFound){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(),"Cliente não encontrado");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
}
