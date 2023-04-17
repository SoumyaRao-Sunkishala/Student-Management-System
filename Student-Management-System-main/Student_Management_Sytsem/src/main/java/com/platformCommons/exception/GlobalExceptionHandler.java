package com.platformCommons.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException me,WebRequest req) {
		
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), "Validation Error", HttpStatus.BAD_REQUEST, me.getBindingResult().getFieldError().getDefaultMessage()) ;
		
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<ErrorDetails> adminExceptionHandler(AdminException ae, WebRequest req){
		
		
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(),ae.getMessage(),HttpStatus.NOT_FOUND,req.getDescription(false));
		
				
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<ErrorDetails> studentExceptionHandler(StudentException se, WebRequest req){
		
		
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(),se.getMessage(),HttpStatus.NOT_FOUND,req.getDescription(false));
		
				
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(CourseException.class)
	public ResponseEntity<ErrorDetails> courseExceptionHandler(CourseException ce, WebRequest req){
		
		
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(),ce.getMessage(),HttpStatus.NOT_FOUND,req.getDescription(false));
		
				
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AddressException.class)
	public ResponseEntity<ErrorDetails> AddressExceptionHandler(AddressException ae, WebRequest req){
		
		
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(),ae.getMessage(),HttpStatus.NOT_FOUND,req.getDescription(false));
		
				
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentials.class)
	public ResponseEntity<ErrorDetails> InvalidCredentialsExceptionHandler(InvalidCredentials ae, WebRequest req){
		
		
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(),ae.getMessage(),HttpStatus.NOT_FOUND,req.getDescription(false));
		
				
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(Exception e, WebRequest req){
		
		
		ErrorDetails err= new ErrorDetails(LocalDateTime.now(),e.getMessage(),HttpStatus.NOT_FOUND,req.getDescription(false));
		
				
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.NOT_FOUND);
	}
	
	
}
