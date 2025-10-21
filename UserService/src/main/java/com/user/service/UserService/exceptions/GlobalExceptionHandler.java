package com.user.service.UserService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.service.UserService.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourecNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourecNotFoundException ex){
		
		String message=ex.getMessage();
		 ApiResponse respons= ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(respons, HttpStatus.NOT_FOUND);
	}

}
