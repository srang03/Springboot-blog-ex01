package com.example.demo.handler;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ResponseDTO;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public ResponseDTO<String> handleIllegalArgumentException(Exception e) {
		return new ResponseDTO<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}
	
}
