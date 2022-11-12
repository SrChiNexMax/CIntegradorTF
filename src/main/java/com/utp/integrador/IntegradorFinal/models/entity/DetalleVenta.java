package com.utp.integrador.IntegradorFinal.models.entity;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "detalleventa")
public class DetalleVenta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetalles;
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "idProducto", referencedColumnName = "idProducto")
	private Producto producto;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "idComprobante", referencedColumnName = "idComprobante")
	private Ventas ventas;
	
	
	@Column(precision = 12, scale=2)
	private BigInteger precioUnidad;
	
	private int cantidad;
	
}
