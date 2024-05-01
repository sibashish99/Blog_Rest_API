package com.blog.proj.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.HttpStatus;
import com.blog.proj.payloads.ApiResponse;

@RestControllerAdvice()
public class GlobalExceptionHandler {
	 
	    @ExceptionHandler(ResourceNotFoundException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
	        // Just use the exception message without formatting
	        String errorMessage = ex.getMessage();
	        ApiResponse response = new ApiResponse(errorMessage, false);
	        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	    }
}
