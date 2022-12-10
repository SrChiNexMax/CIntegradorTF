package com.utp.integrador.IntegradorFinal.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.utp.integrador.IntegradorFinal.models.entity.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {
	
    @Query("SELECT c FROM Cliente c wHERE"
    + " CONCAT(c.idCliente, c.dniRuc, c.nombre, c.telefono, c.direccion)"
    + " LIKE %?1%")
    public List<Cliente> filtrarClientes(String palabraClave);

    @Query("SELECT c FROM Cliente c WHERE c.dniRuc= :palabraClave")
    public Cliente unCliente(Integer palabraClave);

    boolean existsByDniRuc(Integer dni);

}
