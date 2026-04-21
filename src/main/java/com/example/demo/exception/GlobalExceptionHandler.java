package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	//Handle the resources not found 
	@ExceptionHandler(ResourcesNotFoundException.class)
	public ResponseEntity<ErrorResponce> handleResourceNotFound(ResourcesNotFoundException ex){
		
		ErrorResponce error = new ErrorResponce(
				ex.getMessage(),
				HttpStatus.NOT_FOUND.value(),
				LocalDateTime.now());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	//Handle the General Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponce> hangleGlobalException(Exception ex){
		
		ErrorResponce error = new ErrorResponce(
				ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				LocalDateTime.now()
				);
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponce> hanglevalidation(MethodArgumentNotValidException ex){
		
		ErrorResponce error = new ErrorResponce(
				"validation failed",
				HttpStatus.BAD_REQUEST.value(),
				LocalDateTime.now()
				);
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
				
	}
}
