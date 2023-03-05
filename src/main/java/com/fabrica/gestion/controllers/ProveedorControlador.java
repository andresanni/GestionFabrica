package com.fabrica.gestion.controllers;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
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

import com.fabrica.gestion.models.ProveedorModelo;
import com.fabrica.gestion.services.ProveedorServicio;

@RestController
@RequestMapping("/proveedor")
public class ProveedorControlador {
	
	@Autowired
	private ProveedorServicio proveedorServicio;
	
	
	@GetMapping("/all")
	public ArrayList<ProveedorModelo> getProveedores(){
		return proveedorServicio.getProveedores();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProveedorModelo> getById(@PathVariable Long id){
		
		Optional<ProveedorModelo> optionalEntity = proveedorServicio.getProveedor(id);	
		ProveedorModelo proveedor = optionalEntity.orElseThrow(()->new NoSuchElementException());
		
		return ResponseEntity.ok(proveedor);		
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<?> saveProveedor(@Valid @RequestBody ProveedorModelo proveedor) {
		
		ProveedorModelo proveedorGuardadro = proveedorServicio.saveProveedor(proveedor);
		return ResponseEntity.ok(proveedorGuardadro);		
	}	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<ProveedorModelo> actualizarProveedor(@PathVariable Long id, @RequestBody ProveedorModelo proveedor){
		
		proveedor.setId(id);
		Optional<ProveedorModelo> optionalProveedor = proveedorServicio.updateProveedor(proveedor);
		
		ProveedorModelo proveedorActualizado = optionalProveedor.orElseThrow(()->new NoSuchElementException("Capturado"));
		
		return ResponseEntity.ok(proveedorActualizado);			
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProveedor (@PathVariable Long id){
		 
		 return ResponseEntity.ok(proveedorServicio.deleteProveedor(id));
	}
	
	
	
}
