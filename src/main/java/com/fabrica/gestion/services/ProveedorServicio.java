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
	
	public Optional<ProveedorModelo> getProveedor(Long id) {
		return proveedorRepositorio.findById(id);
	} 
	
	public ProveedorModelo saveProveedor(ProveedorModelo proveedor){		
		
		if(getProveedor(proveedor.getId()).isEmpty()) { 
		return proveedorRepositorio.save(proveedor);}
		else {
			throw new RegistroExistenteException("Proveedor", proveedor.getId());
		}
	}	
	
	public Optional<ProveedorModelo> updateProveedor(ProveedorModelo proveedor) {	
		
		Optional <ProveedorModelo> optionalEntity = getProveedor(proveedor.getId());
		
		if(optionalEntity.isPresent()) {
			return Optional.of(proveedorRepositorio.save(proveedor));
		}
		else
		return  Optional.empty();		
	}
	
	
	public String deleteProveedor(Long id) {
		
		Optional<ProveedorModelo> optionalEntity = getProveedor(id);
		
		if(optionalEntity.isEmpty()) {			
			throw new RegistroNoEncontradoException("Proveedor", id);
		}
		else {
		proveedorRepositorio.deleteById(id);
		return "Registro borrado con exito";
		}
	}
	
}
