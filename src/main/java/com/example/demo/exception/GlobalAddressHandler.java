package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalAddressHandler {

	@ExceptionHandler(AddressResorceNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleResoucesNotFound(AddressResorceNotFoundException ex){
		
		ErrorMessage error = new ErrorMessage(
				ex.getMessage(),
				HttpStatus.NOT_FOUND.value(),
				LocalDateTime.now()
				);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleGlobalException(Exception ex){
		ErrorMessage error = new ErrorMessage(
				ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				LocalDateTime.now()
				);
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	public ResponseEntity<ErrorMessage> handleValidation(MethodArgumentNotValidException ex){
		ErrorMessage error = new ErrorMessage(
				"Validation falied",
				HttpStatus.BAD_REQUEST.value(),
				LocalDateTime.now()
				);
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}
