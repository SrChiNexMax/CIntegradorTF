package com.utp.integrador.IntegradorFinal.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.integrador.IntegradorFinal.models.entity.Ventas;

public interface VentasDao extends JpaRepository<Ventas, Long> {
	
}
