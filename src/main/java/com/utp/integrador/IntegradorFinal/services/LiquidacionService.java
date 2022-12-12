package com.utp.integrador.IntegradorFinal.services;

import com.utp.integrador.IntegradorFinal.models.entity.Liquidacion;

import java.util.List;

public interface LiquidacionService {
    public void guardarLiquidacion(Liquidacion liquidacion);

    public List<Liquidacion> listarLiquidacion();
}
