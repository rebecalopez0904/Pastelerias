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
import org.springframework.web.server.ResponseStatusException;

import com.ipn.mx.domain.entities.Comentario;
import com.ipn.mx.service.ComentarioService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiComentarios")
public class ComentarioController {
	@Autowired
    ComentarioService service;

    @GetMapping("/comentarios")
    @ResponseStatus(HttpStatus.OK)
    public List<Comentario> mostrarComentarios(){
        return service.findAll();
    }

    @GetMapping("/comentarios/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Comentario mostrarComentario(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/comentarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Comentario crearComentario(@RequestBody Comentario comentario) {
        return service.save(comentario);
    }

    @DeleteMapping("/comentarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarComentario(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/comentarios/producto/{idProducto}")
    public List<Comentario> ComentariosByProductId(@PathVariable Long idProducto) {
        return service.findAllByProductoId(idProducto);
    }

    @PostMapping("/comentarios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Comentario actualizarComentario(@RequestBody Comentario comentario, @PathVariable Long id) {
        Comentario c = service.findById(id);
        if (c == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comentario no encontrado");
        }
        c.setUsuario(comentario.getUsuario());
        c.setProducto(comentario.getProducto());
        c.setTextoComentario(comentario.getTextoComentario());
        c.setFechaComentario(comentario.getFechaComentario());
        return service.save(c);
    }

}