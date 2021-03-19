package com.bta.casino.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerAdvisor {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> exceptionHandler(RuntimeException re, WebRequest webRequest) {
		final String body = re.getMessage();
		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
}
