package com.ipn.mx.domain.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.domain.entities.Usuarios;

public interface UsuariosRepository extends CrudRepository<Usuarios, Long>{
	@Query("SELECT u FROM Usuarios u WHERE u.correo_usuario = ?1 AND u.contrasena_usuario = ?2")
    Usuarios findByUsernameAndPassword(String email, String password);
}
