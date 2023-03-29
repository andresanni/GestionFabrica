package com.fabrica.gestion.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="insumos")
public class InsumoModelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idinsumos")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="rubro")
	private RubroInsumoModelo rubro;
	
	private String articulo;
	
	@ManyToOne
	@JoinColumn(name="proveedor")
	private ProveedorModelo proveedor;
	
	private float precio;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RubroInsumoModelo getRubro() {
		return rubro;
	}

	public void setRubro(RubroInsumoModelo rubro) {
		this.rubro = rubro;
	}

	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public ProveedorModelo getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorModelo proveedor) {
		this.proveedor = proveedor;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
}
