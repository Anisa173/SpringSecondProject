package com.film.demofilm.domain.exception;

import java.time.LocalDateTime;

public class GenericExceptionResponse {

	private LocalDateTime time = LocalDateTime.now();
	private Integer statusCode;
	private String message;
	private String path;

	public GenericExceptionResponse() {
		super();

	}

	public GenericExceptionResponse( Integer errorStatusCode,LocalDateTime timestamp,String errorMessage, String url) {
		super();
		this.time = timestamp;
		this.statusCode = errorStatusCode;
		this.message = errorMessage;
		this.path = url;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String toString() {
		return "GlobalExceptionResponse[time=" + time + ",statusCode=" + statusCode + ",message=" + message + ",path="
				+ path + "]";
	}

}
