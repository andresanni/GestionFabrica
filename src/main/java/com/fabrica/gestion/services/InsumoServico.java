package com.fabrica.gestion.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.fabrica.gestion.excepciones.RegistroNoEncontradoException;
import com.fabrica.gestion.models.InsumoModelo;

import com.fabrica.gestion.repositories.IInsumoRepositorio;

@Service
public class InsumoServico implements CrudService<InsumoModelo>{
	
	@Autowired
	private IInsumoRepositorio insumoRepositorio;
	
	@Override
	public ArrayList<InsumoModelo> getAll() {
		return (ArrayList<InsumoModelo>) insumoRepositorio.findAll();
	}

	@Override
	public InsumoModelo getById(Long id) {
		
		Optional<InsumoModelo> optionalEntity = insumoRepositorio.findById(id);
		if (optionalEntity.isPresent()) {
			return optionalEntity.get();
		} else
			throw new RegistroNoEncontradoException("Insumo", id);
	}

	@Override
	public InsumoModelo save(InsumoModelo entity) {		
		return insumoRepositorio.save(entity);
		
	}

	@Override
	public InsumoModelo update(InsumoModelo insumo) {
		Optional<InsumoModelo> check = insumoRepositorio.findById(insumo.getId());
		if (check.isPresent()) {
			return insumoRepositorio.save(insumo);
		} else
			throw new RegistroNoEncontradoException("Insumo", insumo.getId());
	}

	@Override
	public void deleteById(Long id) {

		Optional<InsumoModelo> check = insumoRepositorio.findById(id);
		if (check.isEmpty()) {
			throw new RegistroNoEncontradoException("Insumo", id);
		} else {
			insumoRepositorio.deleteById(id);
		}
		
	}
	
	
}
