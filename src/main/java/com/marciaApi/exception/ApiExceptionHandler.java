package com.marciaApi.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = {ApiRequestException.class})
	public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
		ApiException exception = new ApiException(e.getMessage(),HttpStatus.BAD_REQUEST.value(), ZonedDateTime.now(ZoneId.of("Z")));
		
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {ApiNotFoundException.class})
	public ResponseEntity<Object> handleApiRequestNotFoundException(ApiNotFoundException e) {
		ApiException exception = new ApiException(e.getMessage(),HttpStatus.NOT_FOUND.value(), ZonedDateTime.now(ZoneId.of("Z")));
		
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
	
}
