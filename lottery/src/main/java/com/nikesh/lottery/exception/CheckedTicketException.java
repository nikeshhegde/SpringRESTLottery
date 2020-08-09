package com.nikesh.lottery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CheckedTicketException extends RuntimeException{
	
	public CheckedTicketException(String message) {
		super(message);
	}
}
