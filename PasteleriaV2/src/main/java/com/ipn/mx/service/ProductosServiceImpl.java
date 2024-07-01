package com.ipn.mx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.entities.Productos;
import com.ipn.mx.domain.repository.ProductosRepository;

@Service
public class ProductosServiceImpl implements ProductosService {
	
	@Autowired
	ProductosRepository repositorio;

	@Override
	@Transactional(readOnly = true)
	public List<Productos> findAll() {
		return (List<Productos>) repositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Productos findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Productos save(Productos productos) {
		
		return repositorio.save(productos);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repositorio.deleteById(id);
	}
	
	

}
