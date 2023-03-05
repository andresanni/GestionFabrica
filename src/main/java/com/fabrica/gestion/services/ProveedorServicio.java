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
public class ProveedorServicio {
	
	@Autowired
	IProveedorRepositorio proveedorRepositorio;
	
	
	public ArrayList<ProveedorModelo> getProveedores(){
		return (ArrayList<ProveedorModelo>) proveedorRepositorio.findAll();
	}
	
	public ProveedorModelo getProveedor(Long id) {
		
		Optional<ProveedorModelo> optionalEntity = proveedorRepositorio.findById(id);		
		if(optionalEntity.isPresent()) {
			return optionalEntity.get();			
		}
		else
		throw new RegistroNoEncontradoException("Proveedor", id);
	} 
	
	public ProveedorModelo saveProveedor(ProveedorModelo proveedor){		
		
		Optional<ProveedorModelo> check = proveedorRepositorio.findById(proveedor.getId());
		
		if(check.isEmpty()) { 
		return proveedorRepositorio.save(proveedor);}
		else {
			throw new RegistroExistenteException("Proveedor", proveedor.getId());
		}
	}	
	
	public ProveedorModelo updateProveedor(ProveedorModelo proveedor) {	
		
		Optional <ProveedorModelo> check = proveedorRepositorio.findById(proveedor.getId());
		
		if(check.isPresent()) {
			return proveedorRepositorio.save(proveedor);
		}
		else
			throw new RegistroNoEncontradoException("Proveedor", proveedor.getId());
	}
	
	
	public String deleteProveedor(Long id) {
		
		Optional<ProveedorModelo> check = proveedorRepositorio.findById(id);
		
		if(check.isEmpty()) {			
			throw new RegistroNoEncontradoException("Proveedor", id);
		}
		else {
		proveedorRepositorio.deleteById(id);
		return "Registro borrado con exito";
		}
	}
	
}
