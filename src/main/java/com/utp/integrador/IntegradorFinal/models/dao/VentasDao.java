package com.utp.integrador.IntegradorFinal.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.integrador.IntegradorFinal.models.entity.Ventas;

public interface VentasDao extends JpaRepository<Ventas, Long> {
	
	List<Ventas> findByFacturadoTrue();
	
}
