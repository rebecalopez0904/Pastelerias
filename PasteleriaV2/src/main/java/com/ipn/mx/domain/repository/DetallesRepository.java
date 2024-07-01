package com.ipn.mx.domain.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.domain.entities.DetallesPedido;
import com.ipn.mx.domain.entities.Pedido;

public interface DetallesRepository extends CrudRepository<DetallesPedido, Long>{
	List<DetallesPedido> findAllByPedido(Pedido idPedido);
}
