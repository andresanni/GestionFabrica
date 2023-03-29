package com.fabrica.gestion.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rubro_insumos")
public class RubroInsumoModelo {
	
	@Id
	@Column(name="idrubro_insumos")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descripcion;

	
	public RubroInsumoModelo() {	
		
	}
	
	@JsonCreator(mode= JsonCreator.Mode.DELEGATING)
	public RubroInsumoModelo(Long id) {		
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
