package com.codingclub.banking.AspectModule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.codingclub.banking.exception.NoTransactionFoundException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	 @ExceptionHandler(ConstraintViolationException.class)
	    protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex) {
	        List<String> errors = ex.getConstraintViolations().stream()
	                                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
	                                .collect(Collectors.toList());
	        System.out.println("Values :: "+  errors.toString());
	       // ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, "Validation Error", errors);
	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	    }
	
	
	   @ResponseStatus(HttpStatus.BAD_REQUEST)
	   @ExceptionHandler(NoTransactionFoundException.class)
	   protected ResponseEntity<Object> notransactionfoundexception(NoTransactionFoundException ex) {
		   
		   HashMap errormap = new HashMap();
		   
		   errormap.put("Message", ex.getMessage());
       return new ResponseEntity<>(errormap, HttpStatus.BAD_REQUEST);
    }
		
	}


