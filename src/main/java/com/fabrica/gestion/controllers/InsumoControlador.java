package com.fabrica.gestion.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrica.gestion.models.InsumoModelo;

import com.fabrica.gestion.services.InsumoServico;

@RestController
@RequestMapping("/insumos")
public class InsumoControlador implements CrudController<InsumoModelo> {
	
	@Autowired
	private InsumoServico insumoServico;
	
	@Override
	@GetMapping("/all")
	public ArrayList<InsumoModelo> getAll() {
		
		return insumoServico.getAll();
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<InsumoModelo> getById(@PathVariable Long id) {
		InsumoModelo insumo = insumoServico.getById(id);
		return ResponseEntity.ok(insumo);
	}

	@Override
	@PostMapping("/save")
	public ResponseEntity<InsumoModelo> save(@Valid @RequestBody InsumoModelo insumo) {
		InsumoModelo insumoGuardado = insumoServico.save(insumo); 
		return ResponseEntity.ok(insumoGuardado);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<InsumoModelo> update(@PathVariable Long id, @RequestBody InsumoModelo insumo) {
		insumo.setId(id);
		InsumoModelo insumoActualizado = insumoServico.update(insumo);
		return ResponseEntity.ok(insumoActualizado);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<InsumoModelo> delete(@PathVariable Long id) {
		insumoServico.deleteById(id);
		return ResponseEntity.noContent().build();
	}


	
}
