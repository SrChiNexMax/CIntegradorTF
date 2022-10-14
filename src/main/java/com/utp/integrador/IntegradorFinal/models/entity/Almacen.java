package com.utp.integrador.IntegradorFinal.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "almacen")
@PrimaryKeyJoinColumn(name = "idProducto")
public class Almacen extends Producto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "idProducto")
	private Producto Producto;
	*/
	private int unidadesExistentes;
	private int unidadesEnPedido;
	
	private boolean estaSuspendido;

}
