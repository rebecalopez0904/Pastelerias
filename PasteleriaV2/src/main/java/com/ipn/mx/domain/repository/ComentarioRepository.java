package com.ipn.mx.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipn.mx.domain.entities.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    List<Comentario> findAllByProductoIdProducto(Long productoId);
}
