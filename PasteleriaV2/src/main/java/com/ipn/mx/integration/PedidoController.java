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

import com.ipn.mx.domain.entities.Pedido;
import com.ipn.mx.service.PedidoService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiPedidos")
public class PedidoController {
    @Autowired
    PedidoService service;

    @GetMapping("/pedidos")
    @ResponseStatus(HttpStatus.OK)
    public List<Pedido> mostrarPedidos(){
        return service.findAll();
    }

    @GetMapping("/pedidos/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido mostrarPedido(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/pedidos")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return service.save(pedido);
    }

    @DeleteMapping("/pedidos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPedido(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PostMapping("/pedidos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido actualizarPedido(@RequestBody Pedido pedido, @PathVariable Long id) {
        Pedido p = service.findById(id);
        p.setId_usuario(pedido.getId_usuario());
        p.setFecha_pedido(pedido.getFecha_pedido());
        p.setTotal_pedido(pedido.getTotal_pedido());
        return service.save(p);
    }
}
