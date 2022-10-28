package com.utp.integrador.IntegradorFinal.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.utp.integrador.IntegradorFinal.models.dao.AlmacenDao;
import com.utp.integrador.IntegradorFinal.models.entity.Almacen;
import com.utp.integrador.IntegradorFinal.services.AlmacenService;

public class AlmacenServiceImpl implements AlmacenService {
	
	@Autowired
	private AlmacenDao almacenDao;

	@Override
	public List<Almacen> listarAlmacen() {
		
		return null;
	}

	@Override
	public void guardar(Almacen almacen) {


	}

	@Override
	public Almacen encontrarAlmacen(Almacen almacen) {
		return null;
	}

}
