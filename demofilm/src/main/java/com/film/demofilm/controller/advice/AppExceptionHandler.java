package com.film.demofilm.controller.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;
import com.film.demofilm.domain.exception.AppException;
import com.film.demofilm.domain.exception.GenericExceptionResponse;

@ControllerAdvice
public class AppExceptionHandler {
	@ExceptionHandler(value = { AppException.class })
	public ResponseEntity<GenericExceptionResponse> handlerAppException(AppException appException,
			HttpServletRequest request) {
		GenericExceptionResponse resp_request = new GenericExceptionResponse(HttpStatus.NOT_FOUND.value(),
				LocalDateTime.now(), request.getRequestURI(), appException.getMessage());

		return new ResponseEntity<GenericExceptionResponse>(resp_request, HttpStatus.BAD_REQUEST);

	}
}
