package com.fabrica.gestion.excepciones;


import java.util.NoSuchElementException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex , WebRequest request){
		
		String cuerpoRepuesta = "No existe proveedor con ese ID";
		return handleExceptionInternal(ex, cuerpoRepuesta, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleMethodArgumentNotValidException (DataIntegrityViolationException ex, WebRequest request){
		
		String errorMessage = ex.getCause().getCause().getMessage();		
		return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(RegistroExistenteException.class)
	public ResponseEntity<Object> handleRegistroExistenteException (RegistroExistenteException ex, WebRequest request){
		String errorMessage  = ex.getMessage();
		return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.CONFLICT, request);	
		
	}
	
	@ExceptionHandler(RegistroNoEncontradoException.class)
	public ResponseEntity<Object> handleRegistroNoEncontradoException(RegistroNoEncontradoException ex, WebRequest request){
		String errorMessage = ex.getMessage();
		return handleExceptionInternal(ex, errorMessage, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
