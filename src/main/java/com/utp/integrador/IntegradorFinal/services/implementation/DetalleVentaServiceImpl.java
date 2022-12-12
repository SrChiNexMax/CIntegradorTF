package com.utp.integrador.IntegradorFinal.services.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.utp.integrador.IntegradorFinal.models.dao.VentasDao;
import com.utp.integrador.IntegradorFinal.models.entity.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utp.integrador.IntegradorFinal.models.dao.DetalleVentaDao;
import com.utp.integrador.IntegradorFinal.models.entity.DetalleVenta;
import com.utp.integrador.IntegradorFinal.services.DetalleVentaService;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

    @Autowired
    private VentasDao ventasDao;
    @Autowired
    private DetalleVentaDao detalleVentaDao;

    @Override
    public List<DetalleVenta> listarDetalleVenta(Long idComprobante) {
        return (List<DetalleVenta>) detalleVentaDao.listarDetalles(idComprobante);
    }

    @Override
    public List<DetalleVenta> listarDVporLiquidado() {
        return detalleVentaDao.findByVentas_FacturadoTrueAndVentas_LiquidadoFalse();
    }

    @Override
    public void guardar(DetalleVenta detalleVenta) {
        detalleVentaDao.save(detalleVenta);
    }

    @Override
    public void eliminar(Long id) {
        detalleVentaDao.deleteById(id);
    }

    @Override
    @Transactional
    public DetalleVenta encontrarUnDetalleVenta(Long idDetalles){
        return detalleVentaDao.findById(idDetalles).orElse(null);
    }

}
