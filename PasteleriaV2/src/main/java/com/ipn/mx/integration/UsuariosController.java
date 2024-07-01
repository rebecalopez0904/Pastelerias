package com.ipn.mx.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.mx.domain.entities.Usuarios;
import com.ipn.mx.service.UsuariosService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiUsuarios")
public class UsuariosController {
	@Autowired
	UsuariosService service;
	
	@GetMapping("/usuarios")
	@ResponseStatus(HttpStatus.OK)
	public List<Usuarios> mostrarUsuarios(){
		return service.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuarios mostrarUsuario(@PathVariable Long id){
		return service.findById(id);
	}
	
	@GetMapping("/usuarios/{email}/{password}")
	@ResponseStatus(HttpStatus.OK)
	public Usuarios login(@PathVariable String email, @PathVariable String password){
		return service.login(email, password);
	}
	
	@PostMapping("/usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuarios crearUsuario(@RequestBody Usuarios usuario) {
		return service.save(usuario);
	}
	
	@DeleteMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarUsuario(@PathVariable Long id) {
		service.deteleById(id);
	}
	
	@PostMapping("/usuarios/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuarios actualizarUsuario(@RequestBody Usuarios usuario, @PathVariable Long id) {
		Usuarios u = service.findById(id);
		u.setNombre_usuario(usuario.getNombre_usuario());
		u.setCorreo_usuario(usuario.getCorreo_usuario());
		u.setContrasena_usuario(usuario.getContrasena_usuario());
		u.setTelefono_usuario(usuario.getTelefono_usuario());
		u.setDireccion_usuario(usuario.getDireccion_usuario());
		return service.save(u);
	}
}
