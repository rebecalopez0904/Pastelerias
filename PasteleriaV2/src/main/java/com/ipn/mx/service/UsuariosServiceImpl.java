package com.ipn.mx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.entities.Usuarios;
import com.ipn.mx.domain.repository.UsuariosRepository;

@Service
public class UsuariosServiceImpl implements UsuariosService{

	@Autowired
	UsuariosRepository repositoryUser;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuarios> findAll() {
		return (List<Usuarios>) repositoryUser.findAll();
	}

	@Override
	@Transactional
	public Usuarios save(Usuarios usuario) {
		return repositoryUser.save(usuario);
	}

	@Override
	@Transactional
	public void deteleById(Long id) {
		repositoryUser.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuarios findById(Long id) {
		return repositoryUser.findById(id).orElse(null);
	}

	@Override
    @Transactional(readOnly = true)
    public Usuarios login(String email, String password) {
        Usuarios user = repositoryUser.findByUsernameAndPassword(email, password);
        return user;
    }

}
