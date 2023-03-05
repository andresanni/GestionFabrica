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
import com.fabrica.gestion.models.ProveedorModelo;
import com.fabrica.gestion.services.ProveedorServicio;

@RestController
@RequestMapping("/proveedor")
public class ProveedorControlador implements CrudController<ProveedorModelo>{

	@Autowired
	private ProveedorServicio proveedorServicio;

	@GetMapping("/all")
	public ArrayList<ProveedorModelo> getAll() {
		return proveedorServicio.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProveedorModelo> getById(@PathVariable Long id) {

		ProveedorModelo proveedor = proveedorServicio.getById(id);
		return ResponseEntity.ok(proveedor);
	}

	@PostMapping("/save")
	public ResponseEntity<ProveedorModelo> save(@Valid @RequestBody ProveedorModelo proveedor) {

		ProveedorModelo proveedorGuardadro = proveedorServicio.save(proveedor);
		return ResponseEntity.ok(proveedorGuardadro);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProveedorModelo> update(@PathVariable Long id,
			@RequestBody ProveedorModelo proveedor) {

		proveedor.setId(id);
		ProveedorModelo proveedorActualizado = proveedorServicio.update(proveedor);
		return ResponseEntity.ok(proveedorActualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ProveedorModelo> delete(@PathVariable Long id) {
		proveedorServicio.deleteById(id);
		return ResponseEntity.noContent().build();
	}



}
