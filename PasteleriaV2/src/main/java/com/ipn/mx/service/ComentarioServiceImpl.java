package com.ipn.mx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.entities.Comentario;
import com.ipn.mx.domain.repository.ComentarioRepository;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    ComentarioRepository repositoryComment;

    @Override
    @Transactional(readOnly = true)
    public List<Comentario> findAll() {
        return (List<Comentario>) repositoryComment.findAll();
    }

    @Override
    @Transactional
    public Comentario save(Comentario comentario) {
        return repositoryComment.save(comentario);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repositoryComment.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Comentario findById(Long id) {
        return repositoryComment.findById(id).orElse(null);
    }

	@Override
	@Transactional(readOnly = true)
	public List<Comentario> findAllByProductoId(Long idProducto) {
		return repositoryComment.findAllByProductoIdProducto(idProducto);
	}
}
