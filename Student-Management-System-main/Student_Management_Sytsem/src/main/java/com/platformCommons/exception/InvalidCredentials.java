package com.platformCommons.exception;

public class InvalidCredentials extends RuntimeException {

	public InvalidCredentials() {
		
	}
	
	public InvalidCredentials(String msg) {
		super(msg);
	}
}
