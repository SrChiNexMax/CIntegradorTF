package com.utp.integrador.IntegradorFinal.models.dao;

import java.util.List;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utp.integrador.IntegradorFinal.models.entity.Cliente;
import com.utp.integrador.IntegradorFinal.models.entity.Ventas;

public interface VentasDao extends JpaRepository<Ventas, Long> {

    @Modifying
    @Query("UPDATE Ventas v SET v.cliente = :cliente, v.tipoComprobante = :tipoDeComprobante, v.importe = :importe WHERE v.idComprobante = :idComprobante")
    void modificarVenta(@Param(value = "idComprobante") long idComprobante,@Param(value = "cliente") Cliente cliente,@Param(value = "tipoDeComprobante") String tipoDeComprobante,@Param(value = "importe") BigDecimal importe);
	
	List<Ventas> findByFacturadoTrue();
	
    @Modifying
    @Query("UPDATE Ventas v SET v.importe = :importe, v.fechaVenta = :time WHERE v.idComprobante = :idComprobante")
    void finalizarVenta(@Param(value = "idComprobante") long idComprobante,@Param(value = "importe") BigDecimal importe,@Param(value = "time") Timestamp time);
}
