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

import com.ipn.mx.domain.entities.Productos;
import com.ipn.mx.service.ProductosService;

@CrossOrigin(origins = {"*"} )
@RestController
@RequestMapping ("/apiProductos")
public class ProductosController {
	
	@Autowired
	ProductosService service;
	
	@GetMapping("/productos")
	@ResponseStatus(HttpStatus.OK)
	public List<Productos> mostrarProductos() {
		return service.findAll();
	}
	
	@GetMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Productos mostrarProducto(@PathVariable Long id) {
		return service.findById(id);
		
	}
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Productos crearProducto(@RequestBody Productos producto) {
		return service.save(producto);
		
	}
	
	@DeleteMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarProducto(@PathVariable Long id) {
		service.deleteById(id);

	}
	
	@PostMapping("/productos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Productos actualizarProducto(@RequestBody Productos producto, @PathVariable Long id) {
		
		Productos p = service.findById(id);
		p.setNombreProducto(producto.getNombreProducto());
		p.setDescripcionProducto(producto.getDescripcionProducto());
		p.setTamanoProducto(producto.getTamanoProducto());
		p.setImagenProducto(producto.getImagenProducto());
		p.setPrecioProducto(producto.getPrecioProducto());
		p.setSaboresProducto(producto.getSaboresProducto());
		p.setStockProducto(producto.getStockProducto());
		
		return service.save(p);
	}
	
}
