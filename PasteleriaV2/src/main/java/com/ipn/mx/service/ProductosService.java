package com.ipn.mx.service;

import java.util.List;

import com.ipn.mx.domain.entities.Productos;


public interface ProductosService {
	
	public List<Productos> findAll();
	public Productos findById(Long id);
	public Productos save(Productos productos);
	public void deleteById(Long id);

}
