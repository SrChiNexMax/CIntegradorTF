package com.utp.integrador.IntegradorFinal.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idUsuario;
	
	@OneToOne(mappedBy = "usuario")
	private Empleado empleado;
	
	@Column(length = 100)
	private String nombre;
	
	@Column(length = 100)
	private String clave;
	
	@Column(length = 100)
	private String acceso;
	
	@Column(length = 100)
	private String estado;

}
