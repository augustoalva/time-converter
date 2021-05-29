package com.example.timeconverter.exception;

import java.time.DateTimeException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DomainExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { DateTimeException.class, NumberFormatException.class })
	ResponseEntity<ExceptionResponse> handleValidRequestException(Exception ex) {

		return new ResponseEntity<ExceptionResponse>(new ExceptionResponse("EXC100", ex.getLocalizedMessage()),
				HttpStatus.BAD_REQUEST);
	}
	
}
