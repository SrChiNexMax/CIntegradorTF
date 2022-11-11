package com.utp.integrador.IntegradorFinal.models.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utp.integrador.IntegradorFinal.models.entity.Empleado;

public interface EmpleadoDao extends JpaRepository<Empleado, Long> {

	@Query("SELECT e FROM Empleado e WHERE e.estado LIKE %?1%" )
	public List<Empleado> findLaborando(String estado);

	public Empleado findByDni(String dni);

	@Modifying
	@Query("UPDATE Empleado e SET e.estado = :estado WHERE e.idEmpleado = :idEmpleado")
	void suspenderEmpleado(@Param(value = "idEmpleado") long idEmpleado, @Param(value = "estado") String estado);

	@Modifying
	@Query("UPDATE Empleado e SET e.nombre = :nombre, e.clave = :clave, e.acceso = :acceso WHERE e.idEmpleado = :idEmpleado")
	void modificarUsuario(@Param(value = "idEmpleado") long idEmpleado, @Param(value = "nombre") String nombre, 
	@Param(value = "clave") String clave, @Param(value = "acceso") String acceso);

	@Modifying
	@Query("UPDATE Empleado e SET e.nombre = :nombre, e.dni = :dni, e.telefono = :telefono,"
	+ " e.fechaNacimiento = :fechaNacimiento, e.fechaContratacion = :fechaContratacion,"
	+ " e.direccion = :direccion, e.correoEletronico = :correoEletronico, e.estado = :estado"
	+ " WHERE e.idEmpleado = :idEmpleado")
	void modificarEmpleado(@Param(value = "idEmpleado") long idEmpleado, @Param(value = "nombre") String nombre, 
	@Param(value = "dni") String dni, @Param(value = "telefono") String telefono, 
	@Param(value = "fechaNacimiento") Date fechaNacimiento, @Param(value = "fechaContratacion") Date fechaContratacion, 
	@Param(value = "direccion") String direccion, @Param(value = "correoEletronico") String correoEletronico, @Param(value = "estado") String estado);
	
}
