package com.utp.integrador.IntegradorFinal.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.utp.integrador.IntegradorFinal.models.entity.DetalleVenta;

public interface DetalleVentaDao extends JpaRepository<DetalleVenta, Long> {
	
    @Query("SELECT d FROM DetalleVenta d WHERE d.ventas.idComprobante= :idComprobante")
    public List<DetalleVenta> listarDetalles(Long idComprobante);

    public DetalleVenta findByidDetalles(Long idDetalles);

    public List<DetalleVenta> findByVentas_FacturadoTrueAndVentas_LiquidadoFalse();
}
