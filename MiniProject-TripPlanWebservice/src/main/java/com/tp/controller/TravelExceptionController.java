package com.tp.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tp.entity.ExceptionEntity;

@RestControllerAdvice
public class TravelExceptionController {

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<ExceptionEntity> handleException(Exception e) {
		ExceptionEntity entity = ExceptionEntity.builder().error(e.getMessage()).timestamp(LocalDateTime.now())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).build();
		
		return new ResponseEntity<ExceptionEntity>(entity,HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
