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

import com.ipn.mx.domain.entities.DetallesPedido;
import com.ipn.mx.domain.entities.Pedido;
import com.ipn.mx.service.DetallesService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiDetallesPedido")
public class DetallesController {
	@Autowired
	DetallesService service;
	
	@GetMapping("/detallesPedido")
	@ResponseStatus(HttpStatus.OK)
	public List<DetallesPedido> mostrarDetalles(){
		return service.findAll();
	}
	
	@GetMapping("/detallesPedido/{id}")
	@ResponseStatus(HttpStatus.OK)
	public DetallesPedido mostrarDetalles(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@GetMapping("/detallesPedido/{id}/pedido")
	@ResponseStatus(HttpStatus.OK)
	public List<DetallesPedido> mostrarDetallePorPedido(@PathVariable Pedido id) {
		return (List<DetallesPedido>) service.findAllByPedido(id);
	}
	
	@PostMapping("/detallesPedido")
	@ResponseStatus(HttpStatus.CREATED)
	public DetallesPedido crearDetalles(@RequestBody DetallesPedido detalles) {
		return service.save(detalles);
	}
	
	@DeleteMapping("/detallesPedido/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarDetalles(@PathVariable Long id) {
		service.deleteById(id);
	}
	
	@PostMapping("/detallesPedido/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public DetallesPedido actualizarDetalle(@RequestBody DetallesPedido detalle, @PathVariable Long id) {
        DetallesPedido d = service.findById(id);
        d.setCantidad_detalle(detalle.getCantidad_detalle());
        d.setPedido(detalle.getPedido());
        d.setPrecioUnitario_detalle(detalle.getPrecioUnitario_detalle());
        d.setProducto(detalle.getProducto());
        d.setSaborProducto_detalle(detalle.getSaborProducto_detalle());
        d.setTamanoProducto_detalle(detalle.getTamanoProducto_detalle());
        return service.save(d);
    }
}
