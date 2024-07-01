package com.ipn.mx.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipn.mx.domain.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}