package com.ipn.mx.service;

import java.util.List;

import com.ipn.mx.domain.entities.DetallesPedido;
import com.ipn.mx.domain.entities.Pedido;

public interface DetallesService {
	public List<DetallesPedido> findAll();
	public DetallesPedido save(DetallesPedido detalles);
	public void deleteById(Long id);
	public DetallesPedido findById(Long id);
	List<DetallesPedido> findAllByPedido(Pedido idPedido);
}
