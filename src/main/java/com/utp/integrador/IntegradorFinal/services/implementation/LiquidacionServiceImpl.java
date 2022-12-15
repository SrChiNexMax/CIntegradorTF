package com.utp.integrador.IntegradorFinal.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.integrador.IntegradorFinal.models.dao.LiquidacionDao;
import com.utp.integrador.IntegradorFinal.models.entity.Liquidacion;
import com.utp.integrador.IntegradorFinal.services.LiquidacionService;

@Service
public class LiquidacionServiceImpl implements LiquidacionService {

    @Autowired
    private LiquidacionDao liquidacionDao;

    @Override
    @Transactional
    public void guardarLiquidacion(Liquidacion liquidacion) {
        liquidacionDao.save(liquidacion);
    }

    @Override
    public List<Liquidacion> listarLiquidacion() {
        return liquidacionDao.findAll();
    }
}
