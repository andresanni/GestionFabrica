package com.fabrica.gestion.excepciones;

@SuppressWarnings("serial")
public class RegistroNoEncontradoException extends RuntimeException {
	
	private Long id;	
	private String entidad;
	
	
	public RegistroNoEncontradoException(String entidad, Long id) {
				
		this.id = id;		
		this.entidad = entidad;
	}


	@Override
	public String getMessage() {
		
		return "No existe registro con id "+ this.id + " en la tabla " + this.entidad;
	}
	
	
	

}
