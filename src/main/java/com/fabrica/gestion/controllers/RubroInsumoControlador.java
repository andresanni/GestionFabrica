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

import com.fabrica.gestion.models.RubroInsumoModelo;
import com.fabrica.gestion.services.RubroInsumoServicio;

@RestController
@RequestMapping("/rubro_insumo")
public class RubroInsumoControlador {
	
	@Autowired
	private RubroInsumoServicio rubroInsumoServicio;
	
	@GetMapping("/all")
	public ArrayList<RubroInsumoModelo> getAll(){
		return rubroInsumoServicio.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RubroInsumoModelo> getById(@PathVariable Long id){
		RubroInsumoModelo rubroInsumo = rubroInsumoServicio.getById(id);
		
		return ResponseEntity.ok(rubroInsumo);
	}
	
	@PostMapping("/save")
	public ResponseEntity<RubroInsumoModelo> saveRubroInsumo(@Valid @RequestBody RubroInsumoModelo rubroInsumo){
		
		RubroInsumoModelo rubroInsumoGuardado = rubroInsumoServicio.save(rubroInsumo);
		return ResponseEntity.ok(rubroInsumoGuardado);		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RubroInsumoModelo> updateRubroInsumo(@PathVariable Long id, @RequestBody RubroInsumoModelo rubroInsumo){
		
		rubroInsumo.setId(id);
		RubroInsumoModelo rubroInsumoActualizado = rubroInsumoServicio.update(rubroInsumo);
		
		return ResponseEntity.ok(rubroInsumoActualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<RubroInsumoModelo> deleteRubroInsumo(@PathVariable Long id){
		rubroInsumoServicio.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
