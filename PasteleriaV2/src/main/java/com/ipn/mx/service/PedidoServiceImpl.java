package com.ipn.mx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.entities.Pedido;
import com.ipn.mx.domain.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository repositoryOrder;

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> findAll() {
        return (List<Pedido>) repositoryOrder.findAll();
    }

    @Override
    @Transactional
    public Pedido save(Pedido pedido) {
        return repositoryOrder.save(pedido);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repositoryOrder.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Pedido findById(Long id) {
        return repositoryOrder.findById(id).orElse(null);
    }
}
