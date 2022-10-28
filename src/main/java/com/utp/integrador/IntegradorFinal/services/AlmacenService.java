package com.utp.integrador.IntegradorFinal.services;

import java.util.List;

import com.utp.integrador.IntegradorFinal.models.entity.Almacen;

public interface AlmacenService {
	
	public List<Almacen> listarAlmacen();
	
	public void guardar(Almacen almacen);
	
	public Almacen encontrarAlmacen(Almacen almacen);

}
