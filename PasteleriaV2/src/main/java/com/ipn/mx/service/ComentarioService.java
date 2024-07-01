package com.ipn.mx.service;

import java.util.List;

import com.ipn.mx.domain.entities.Comentario;

public interface ComentarioService {
    List<Comentario> findAll();
    Comentario save(Comentario comentario);
    void deleteById(Long id);
    Comentario findById(Long id);
    List<Comentario> findAllByProductoId(Long idProducto);
}