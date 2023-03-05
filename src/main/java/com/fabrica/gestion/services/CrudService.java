package com.fabrica.gestion.services;

import java.util.ArrayList;

public interface CrudService<T> {
	
	ArrayList<T> getAll();
	T getById(Long id);
	T save (T entity);
	T update(T entity);
	void deleteById(Long id);
	
}
