package com.utp.integrador.IntegradorFinal.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.integrador.IntegradorFinal.models.dao.VentasDao;
import com.utp.integrador.IntegradorFinal.models.entity.Ventas;
import com.utp.integrador.IntegradorFinal.services.VentaService;

@Service
public class VentaServiceImpl implements VentaService{

    @Autowired
    private VentasDao ventasDao;

    @Override
    public List<Ventas> listarVentas() {
        return (List<Ventas>) ventasDao.findAll();
    }

    @Override
    public void guardar(Ventas ventas) {
        ventasDao.save(ventas);
    }

    @Override
    public void eliminar(Long id) {
        ventasDao.deleteById(id);
    }

    @Override
    @Transactional
    public Ventas encontrarVentaPorId(Long id) {
        return ventasDao.findById(id).orElseThrow();
    }
    
    @Transactional
    public List<Ventas> encontrarVentasPorFacturado() {
    	return ventasDao.findByFacturadoTrue();
    	
    }

}
