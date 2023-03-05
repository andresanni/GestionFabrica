package com.fabrica.gestion.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabrica.gestion.excepciones.RegistroExistenteException;
import com.fabrica.gestion.excepciones.RegistroNoEncontradoException;
import com.fabrica.gestion.models.RubroInsumoModelo;
import com.fabrica.gestion.repositories.IRubroInsumoRepositorio;

@Service
public class RubroInsumoServicio implements CrudService<RubroInsumoModelo>{
	
	@Autowired
	private IRubroInsumoRepositorio rubroInsumoRepositorio;
	
	@Override
	public ArrayList<RubroInsumoModelo> getAll() {		
		return (ArrayList<RubroInsumoModelo>) rubroInsumoRepositorio.findAll();
	}

	@Override
	public RubroInsumoModelo getById(Long id) {
		Optional<RubroInsumoModelo> optionalEntity = rubroInsumoRepositorio.findById(id);
		
		if(optionalEntity.isPresent()) {
			RubroInsumoModelo rubroInsumo = optionalEntity.get();
			return rubroInsumo;
		}
		else{
			throw new RegistroNoEncontradoException("RubroInsumos", id);
		}
	}

	@Override
	public RubroInsumoModelo save(RubroInsumoModelo entity) {
		Optional<RubroInsumoModelo> check = rubroInsumoRepositorio.findByDescripcion(entity.getDescripcion());
		if(check.isEmpty()) {
			return rubroInsumoRepositorio.save(entity);
		}
		else throw new RegistroExistenteException("RubroInsumos", check.get().getId());
	}

	@Override
	public RubroInsumoModelo update(RubroInsumoModelo entity) {
		Optional<RubroInsumoModelo> check = rubroInsumoRepositorio.findById(entity.getId());
		if(check.isPresent()) {
			return rubroInsumoRepositorio.save(entity);
		}
		else{
			throw new RegistroNoEncontradoException("RubroInsumos", entity.getId());
		}
	}

	@Override
	public void deleteById(Long id) {
		Optional<RubroInsumoModelo> check = rubroInsumoRepositorio.findById(id);
		if(check.isPresent()) {
			rubroInsumoRepositorio.deleteById(id);
		}
		else {
			throw new RegistroNoEncontradoException("RubroInsumos", id);
		}
	}

}
