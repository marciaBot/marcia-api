package com.marciaApi.exception;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ApiException {
	private final String message;
	private final int status;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss a ", timezone="GMT-3")
	private final ZonedDateTime timestamp;
	
	public ApiException(String message, int status, ZonedDateTime timestamp) {
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	
	
}
