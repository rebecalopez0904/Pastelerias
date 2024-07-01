package com.ipn.mx.domain.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Usuarios")
public class Usuarios implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 5, max = 100, message = "Debe de estar entre 5 y 100")
    @Column(name = "nombre_usuario", nullable = false, length = 100)
    private String nombre_usuario;

    @NotBlank(message = "El correo es obligatorio")
    @Size(min = 6, max = 100, message = "Debe de estar entre 6 y 100")
    @Column(name = "correo_usuario", nullable = false, length = 100)
    private String correo_usuario;

    @NotBlank(message = "La contrasena es obligatoria")
    @Size(min = 8, max = 100, message = "Debe de estar entre 8 y 100")
    @Column(name = "contrasena_usuario", nullable = false, length = 100)
    private String contrasena_usuario;

    @NotBlank(message = "El telefono es obligatorio")
    @Size(min = 10, max = 10, message = "Debe de ser de 10 digitos")
    @Column(name = "telefono_usuario", nullable = false, length = 10)
    private String telefono_usuario;

    @NotBlank(message = "La direccion es obligatoria")
    @Size(min = 15, max = 255, message = "Debe de estar entre 15 y 255")
    @Column(name = "direccion_usuario", nullable = false, length = 255)
    private String direccion_usuario;

    @JsonIgnoreProperties(value = {"id_usuario", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(mappedBy = "id_usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pedido> pedidos;

    @JsonIgnoreProperties(value = {"usuario", "hibernateLazyInitializer", "handler"}, allowSetters = true)
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Comentario> comentarios;

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public void setCorreo_usuario(String correo_usuario) {
		this.correo_usuario = correo_usuario;
	}

	public void setContrasena_usuario(String contrasena_usuario) {
		this.contrasena_usuario = contrasena_usuario;
	}

	public void setTelefono_usuario(String telefono_usuario) {
		this.telefono_usuario = telefono_usuario;
	}

	public void setDireccion_usuario(String direccion_usuario) {
		this.direccion_usuario = direccion_usuario;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
}
