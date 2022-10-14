package com.utp.integrador.IntegradorFinal.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.integrador.IntegradorFinal.models.entity.Categoria;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {
	
}
