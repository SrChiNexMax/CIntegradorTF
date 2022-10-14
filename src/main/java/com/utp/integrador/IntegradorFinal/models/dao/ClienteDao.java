package com.utp.integrador.IntegradorFinal.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.integrador.IntegradorFinal.models.entity.DetalleVenta;

public interface ClienteDao extends JpaRepository<DetalleVenta, Long> {
	
}
