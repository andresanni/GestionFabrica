package com.fabrica.gestion.services;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fabrica.gestion.excepciones.RegistroExistenteException;
import com.fabrica.gestion.excepciones.RegistroNoEncontradoException;
import com.fabrica.gestion.models.ProveedorModelo;
import com.fabrica.gestion.repositories.IProveedorRepositorio;

@Service
public class ProveedorServicio implements CrudService<ProveedorModelo> {

	@Autowired
	IProveedorRepositorio proveedorRepositorio;

	public ArrayList<ProveedorModelo> getAll() {
		return (ArrayList<ProveedorModelo>) proveedorRepositorio.findAll();
	}

	public ProveedorModelo getById(Long id) {

		Optional<ProveedorModelo> optionalEntity = proveedorRepositorio.findById(id);
		if (optionalEntity.isPresent()) {
			return optionalEntity.get();
		} else
			throw new RegistroNoEncontradoException("Proveedor", id);
	}

	public ProveedorModelo save(ProveedorModelo proveedor) {

		Optional<ProveedorModelo> check = proveedorRepositorio.findByRazonSocial(proveedor.getRazonSocial());
		if (check.isEmpty()) {
			return proveedorRepositorio.save(proveedor);
		} else {
			throw new RegistroExistenteException("Proveedor", check.get().getId());
		}
	}

	public ProveedorModelo update(ProveedorModelo proveedor) {

		Optional<ProveedorModelo> check = proveedorRepositorio.findById(proveedor.getId());
		if (check.isPresent()) {
			return proveedorRepositorio.save(proveedor);
		} else
			throw new RegistroNoEncontradoException("Proveedor", proveedor.getId());
	}

	public void deleteById(Long id) {

		Optional<ProveedorModelo> check = proveedorRepositorio.findById(id);
		if (check.isEmpty()) {
			throw new RegistroNoEncontradoException("Proveedor", id);
		} else {
			proveedorRepositorio.deleteById(id);
		}
	}

}
