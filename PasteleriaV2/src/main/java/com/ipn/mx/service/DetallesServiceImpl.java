package com.ipn.mx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.entities.DetallesPedido;
import com.ipn.mx.domain.entities.Pedido;
import com.ipn.mx.domain.repository.DetallesRepository;

@Service
public class DetallesServiceImpl implements DetallesService{
	
	@Autowired
	DetallesRepository repositoryDetails;
	
	@Override
	@Transactional(readOnly = true)
	public List<DetallesPedido> findAll() {
		return (List<DetallesPedido>) repositoryDetails.findAll();
	}

	@Override
	@Transactional
	public DetallesPedido save(DetallesPedido detalles) {
		return repositoryDetails.save(detalles);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repositoryDetails.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public DetallesPedido findById(Long id) {
		return repositoryDetails.findById(id).orElse(null);
	}

	@Override
	public List<DetallesPedido> findAllByPedido(Pedido idPedido) {
		return repositoryDetails.findAllByPedido(idPedido);
	}

}
