package com.utp.integrador.IntegradorFinal.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.utp.integrador.IntegradorFinal.models.entity.Cliente;
import com.utp.integrador.IntegradorFinal.models.entity.Ventas;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface VentaService {

    public List<Ventas> listarVentasNoFacturadas();

    public Ventas encontrarVentaPorId(Long id);

    public void guardar(Ventas ventas);

    public void eliminar(Long id);
    
    public List<Ventas> encontrarVentasPorFacturado();

    public void editar(Long id, Cliente cliente, String tipoDeComprobante,BigDecimal importe);

    public void finalizar(Long id,BigDecimal importe,Timestamp time);

    public ResponseEntity<Resource> reportePDF(Long idComprobate);
}
