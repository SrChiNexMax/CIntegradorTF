package com.utp.integrador.IntegradorFinal.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.integrador.IntegradorFinal.models.entity.Marca;

public interface MarcaDao extends JpaRepository<Marca, Long> {
	
}
