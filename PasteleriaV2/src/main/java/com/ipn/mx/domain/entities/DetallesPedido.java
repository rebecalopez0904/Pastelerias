package com.ipn.mx.domain.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "DetallesPedido")
public class DetallesPedido implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;

    @NotBlank(message = "El tamano es obligatorio")
    @Size(min = 1, max = 255, message = "Debe de estar entre 5 y 255")
    @Column(name = "tamanoProducto_detalle", nullable = false, length = 255)
    private String tamanoProducto_detalle;

    @NotNull(message = "El precio unitario es obligatorio")
    @Column(name = "precioUnitario_detalle", nullable = false)
    private double precioUnitario_detalle;

    @NotNull(message = "La cantidad es obligatoria")
    @Column(name = "cantidad_detalle", nullable = false)
    private int cantidad_detalle;

    @NotBlank(message = "El sabor es obligatorio")
    @Size(min = 1, max = 255, message = "Debe de estar entre 5 y 100")
    @Column(name = "saborProducto_detalle", nullable = false, length = 100)
    private String saborProducto_detalle;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "idPedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Productos producto;
    
}