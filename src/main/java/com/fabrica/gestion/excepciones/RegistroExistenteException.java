package com.fabrica.gestion.excepciones;

@SuppressWarnings("serial")
public class RegistroExistenteException extends RuntimeException {
	
	private String entidad;
	private Long id;
	
	
	
	public RegistroExistenteException (String entidad,Long id ) {
		this.entidad=entidad;
		this.id = id;		
	}



	@Override
	public String getMessage() {		
		return "Ya existe un registro con el id "+ this.id + " en la tabla " + this.entidad;
	}
	
	
}
