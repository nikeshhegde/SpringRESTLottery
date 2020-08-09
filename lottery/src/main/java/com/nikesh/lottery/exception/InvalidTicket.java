package com.nikesh.lottery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidTicket extends RuntimeException {

	public InvalidTicket(String message) {
		super(message);
	}
}
