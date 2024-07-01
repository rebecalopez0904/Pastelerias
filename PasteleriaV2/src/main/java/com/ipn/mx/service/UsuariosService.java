package com.ipn.mx.service;

import java.util.List;

import com.ipn.mx.domain.entities.Usuarios;

public interface UsuariosService {
	public List<Usuarios> findAll();
	public Usuarios save(Usuarios usuario);
	public void deteleById(Long id);
	public Usuarios findById(Long id);
	public Usuarios login(String email, String password);
}
