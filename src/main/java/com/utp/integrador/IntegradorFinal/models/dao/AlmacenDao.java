package com.utp.integrador.IntegradorFinal.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.integrador.IntegradorFinal.models.entity.Almacen;

public interface AlmacenDao extends JpaRepository<Almacen, Long> {
	
}