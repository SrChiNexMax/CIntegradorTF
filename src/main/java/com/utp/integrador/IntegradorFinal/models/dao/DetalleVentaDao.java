package com.utp.integrador.IntegradorFinal.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.integrador.IntegradorFinal.models.entity.Persona;

public interface DetalleVentaDao extends JpaRepository<Persona, Long> {
	
}
