package com.wipro.gama.bankapp.exceptionhandler;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice(basePackages = "com.wipro.gama.bankapp.controller")
@RestControllerAdvice
public class ControllerAdviceBank {
	
	@ResponseBody
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MessageExceptionHandler> argumentNotValid(MethodArgumentNotValidException notValid){

		BindingResult result = notValid.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		StringBuilder sb = new StringBuilder("Os campos seguintes não podem ser nulos: ");
		for(FieldError fielderror: fieldErrors) {
			sb.append(" | ");
			sb.append(" -> ");
			sb.append(fielderror.getField());
			sb.append("<-");
		}

		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.BAD_REQUEST.value(), sb.toString());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

}