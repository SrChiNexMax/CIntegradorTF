package com.utp.integrador.IntegradorFinal.models.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "ventas")
public class Ventas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idComprobante;
	
	@Column(length = 100)
	private String tipoComprobante;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "idCliente", referencedColumnName = "idCliente")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "idEmpleado", referencedColumnName = "idEmpleado")
	private Empleado empleado;
	
	private Timestamp fechaVenta;
	
	@Column(precision = 12, scale=2)
	private BigInteger importe;
	
	private boolean suspendido;
	
	private boolean facturado;
	
	private boolean liquidado;

	@OneToMany(mappedBy = "ventas",cascade = CascadeType.ALL)
	private List<DetalleVenta> detalleVentas;
	
}
