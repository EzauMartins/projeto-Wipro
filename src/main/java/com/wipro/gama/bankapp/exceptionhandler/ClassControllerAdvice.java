package com.wipro.gama.bankapp.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "com.wipro.gama.bankapp.controller")
public class ClassControllerAdvice extends ResponseEntityExceptionHandler {

	
	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> clienteNotFound(NotFoundException clienteNotFound){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(),"Cliente não encontrado");
		return new ResponseEntity<MessageExceptionHandler>(error, HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ExceptionHandler(NotFoundExceptionContaCorrente.class)
	public ResponseEntity<MessageExceptionHandler> contaCorrenteNotFound(NotFoundExceptionContaCorrente contaCorrenteNotFound){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(),"Conta Corrente não encontrada");
		return new ResponseEntity<MessageExceptionHandler>(error, HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ExceptionHandler(NotFoundExceptionContaEspecial.class)
	public ResponseEntity<MessageExceptionHandler> contaEspecialNotFound(NotFoundExceptionContaEspecial contaEspecialNotFound){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(),"Conta Especial não encontrada");
		return new ResponseEntity<MessageExceptionHandler>(error, HttpStatus.NOT_FOUND);
	}
	
}
