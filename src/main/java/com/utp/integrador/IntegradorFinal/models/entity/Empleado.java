package com.utp.integrador.IntegradorFinal.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpleado;
	
	@Column(length = 150)
	private String nombre;

	@Column(length = 8)
	private String dni;
	
	private String telefono;
	
	@Column(length = 100)
	private String clave;
	
	@Column(length = 100)
	private String acceso;
	
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date fechaNacimiento;
	
	@DateTimeFormat(pattern = "YYYY-MM-dd")
	private Date fechaContratacion;
	
	@Column(length = 150)
	private String direccion; 
	
	@Column(length = 150)
	private String correoEletronico;
	
	@Column(length = 150)
	private String estado;
	
}
