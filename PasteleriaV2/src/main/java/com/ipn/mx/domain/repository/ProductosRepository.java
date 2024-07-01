package com.ipn.mx.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.domain.entities.Productos;

public interface ProductosRepository extends CrudRepository<Productos, Long> {
}
