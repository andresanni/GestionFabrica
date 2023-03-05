package com.fabrica.gestion.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



public interface CrudController<T> {
	
	@GetMapping("/all")
	public ArrayList<T> getAll();
	
	@GetMapping("/{id}")
	public ResponseEntity<T> getById(@PathVariable Long id);
	
	@PostMapping("/save")
	public ResponseEntity<T> save(@Valid @RequestBody T entity);
	
	@PutMapping("/{id}")
	public ResponseEntity<T> update(@PathVariable Long id,
			@RequestBody T entity);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<T> delete(@PathVariable Long id);
}
