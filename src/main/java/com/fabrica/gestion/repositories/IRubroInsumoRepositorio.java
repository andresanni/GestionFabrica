package com.fabrica.gestion.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fabrica.gestion.models.RubroInsumoModelo;

public interface IRubroInsumoRepositorio extends CrudRepository<RubroInsumoModelo, Long>{
	
	Optional<RubroInsumoModelo> findByDescripcion(String descripcion);
}
