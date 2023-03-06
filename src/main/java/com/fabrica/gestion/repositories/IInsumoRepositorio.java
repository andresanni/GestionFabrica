package com.fabrica.gestion.repositories;

import org.springframework.data.repository.CrudRepository;

import com.fabrica.gestion.models.InsumoModelo;

public interface IInsumoRepositorio extends CrudRepository<InsumoModelo, Long> {

}
