package com.utp.integrador.IntegradorFinal.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utp.integrador.IntegradorFinal.models.entity.Empleado;

public interface EmpleadoDao extends JpaRepository<Empleado, Long> {
	
	public Empleado findByDni(String nombre);
	
}
