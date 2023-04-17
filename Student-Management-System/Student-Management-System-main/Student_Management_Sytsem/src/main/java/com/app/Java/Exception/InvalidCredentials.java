package com.app.Java.Exception;

public class InvalidCredentials extends RuntimeException {

	public InvalidCredentials() {
		
	}
	
	public InvalidCredentials(String msg) {
		super(msg);
	}
}
