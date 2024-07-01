package com.ipn.mx.service;

import java.util.List;

import com.ipn.mx.domain.entities.Pedido;

public interface PedidoService {
    List<Pedido> findAll();
    Pedido save(Pedido pedido);
    void deleteById(Long id);
    Pedido findById(Long id);
}
