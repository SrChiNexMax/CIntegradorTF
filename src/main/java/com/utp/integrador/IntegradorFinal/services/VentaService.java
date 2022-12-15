package com.utp.integrador.IntegradorFinal.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import com.utp.integrador.IntegradorFinal.models.entity.Cliente;
import com.utp.integrador.IntegradorFinal.models.entity.Ventas;

public interface VentaService {

    public List<Ventas> listarVentasNoFacturadas();

    public Ventas encontrarVentaPorId(Long id);

    public void guardar(Ventas ventas);

    public void guardarLiquidadas(List<Ventas> ventas);

    public void eliminar(Long id);
    
    public List<Ventas> encontrarVentasPorFacturado();

    public List<Ventas> encontrarVentasPorFacturadoAndLiquidado();

    public void editar(Long id, Cliente cliente, String tipoDeComprobante,BigDecimal importe);

    public void finalizar(Long id,BigDecimal importe,Timestamp time);

    ResponseEntity<Resource> reportePDF(Long idComprobate);


}
