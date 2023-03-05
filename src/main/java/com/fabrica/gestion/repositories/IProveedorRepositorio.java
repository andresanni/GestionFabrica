package com.fabrica.gestion.repositories;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fabrica.gestion.models.ProveedorModelo;


public interface IProveedorRepositorio extends CrudRepository<ProveedorModelo, Long> {
	
	public Optional<ProveedorModelo>findByRazonSocial(String razonSocial);
	
}
