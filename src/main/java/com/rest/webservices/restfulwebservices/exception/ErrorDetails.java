package com.rest.webservices.restfulwebservices.exception;

import java.time.LocalDate;

public class ErrorDetails {
	private LocalDate timeStamp;
	private String message;
	private String details;
	
	public ErrorDetails(LocalDate timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public LocalDate getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getMessage() {
		return message;
	}

	
}
