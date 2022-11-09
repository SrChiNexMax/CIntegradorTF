package com.utp.integrador.IntegradorFinal.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.utp.integrador.IntegradorFinal.models.entity.Producto;

public interface ProductoDao extends JpaRepository<Producto, Long> {
	
    @Query("SELECT p FROM Producto p WHERE"
    + " CONCAT(p.idProducto, p.nombreProducto, p.marca.nombreMarca, p.categoria.nombreCategoria, p.unidadesExistentes)"
    + " LIKE %?1%")
    public List<Producto> filtrarProductos(String palabraClave);
}