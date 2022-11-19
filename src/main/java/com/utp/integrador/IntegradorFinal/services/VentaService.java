package com.utp.integrador.IntegradorFinal.services;

import java.util.List;

import com.utp.integrador.IntegradorFinal.models.entity.Ventas;

public interface VentaService {

    public List<Ventas> listarVentas();

    public Ventas encontrarVentaPorId(Long id);

    public void guardar(Ventas ventas);

    public void eliminar(Long id);
}
