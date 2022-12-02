package com.utp.integrador.IntegradorFinal.services.implementation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.integrador.IntegradorFinal.models.dao.VentasDao;
import com.utp.integrador.IntegradorFinal.models.entity.Cliente;
import com.utp.integrador.IntegradorFinal.models.entity.Ventas;
import com.utp.integrador.IntegradorFinal.services.VentaService;

@Service
public class VentaServiceImpl implements VentaService{

    @Autowired
    private VentasDao ventasDao;

    @Override
    public List<Ventas> listarVentasNoFacturadas() {
        return ventasDao.findByFacturadoFalse();
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

    @Override
    @Transactional
    public void editar(Long id, Cliente cliente, String tipoDeComprobante,BigDecimal importe){
        ventasDao.modificarVenta(id, cliente, tipoDeComprobante, importe);
    }

    @Override
    @Transactional
    public void finalizar(Long id,BigDecimal importe,Timestamp time){
        ventasDao.finalizarVenta(id, importe, time);
    }

}
