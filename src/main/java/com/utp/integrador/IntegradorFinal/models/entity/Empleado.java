package com.utp.integrador.IntegradorFinal.models.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleado;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idUsuario")
	@MapsId
	private Usuario usuario;
	
	@Column(length = 150)
	private String nombre;
	
	@Column(nullable = true)
	private int dni;
	
	@Column(nullable = true)
	private int telefono;
	
	private Timestamp fechaNacimiento;
	
	private Timestamp fechaContratacion;
	
	@Column(length = 150)
	private String direccion; 
	
	@Column(length = 150)
	private String correoEletronico;
	
	@Column(length = 150)
	private String estado;
	
}
