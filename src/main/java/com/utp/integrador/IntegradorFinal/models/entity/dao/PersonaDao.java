package com.utp.integrador.IntegradorFinal.models.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.integrador.IntegradorFinal.models.entity.Persona;

public interface PersonaDao extends JpaRepository<Persona, Long> {
	
}
