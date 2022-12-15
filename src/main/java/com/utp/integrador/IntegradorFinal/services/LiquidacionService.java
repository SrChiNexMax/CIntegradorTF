package com.utp.integrador.IntegradorFinal.services;

import java.util.List;

import com.utp.integrador.IntegradorFinal.models.entity.Liquidacion;

public interface LiquidacionService {
    public void guardarLiquidacion(Liquidacion liquidacion);

    public List<Liquidacion> listarLiquidacion();
}
