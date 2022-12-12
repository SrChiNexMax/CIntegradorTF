package com.utp.integrador.IntegradorFinal.services;

import java.util.List;

import com.utp.integrador.IntegradorFinal.models.entity.DetalleVenta;

public interface DetalleVentaService {

    public List<DetalleVenta> listarDetalleVenta(Long idComprobante);

    public List<DetalleVenta> listarDVporLiquidado();

    public void guardar(DetalleVenta detalleVenta);

    public void eliminar(Long id);

    public DetalleVenta encontrarUnDetalleVenta(Long idDetalles);
}
