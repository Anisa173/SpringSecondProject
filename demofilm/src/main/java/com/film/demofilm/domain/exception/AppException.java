package com.film.demofilm.domain.exception;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {
	
	private static final long serialVersionUID = 7146283458573938823L;

	private final HttpStatus httpStatus;

	public AppException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
