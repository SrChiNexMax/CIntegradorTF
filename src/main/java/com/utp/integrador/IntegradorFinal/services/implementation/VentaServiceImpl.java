package com.utp.integrador.IntegradorFinal.services.implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.sun.istack.NotNull;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.integrador.IntegradorFinal.models.dao.VentasDao;
import com.utp.integrador.IntegradorFinal.models.entity.Cliente;
import com.utp.integrador.IntegradorFinal.models.entity.Ventas;
import com.utp.integrador.IntegradorFinal.services.VentaService;
import org.springframework.util.ResourceUtils;

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

    @Override
    @NotNull
    public ResponseEntity<Resource> reportePDF(Long idComprobate) {
        Optional<Ventas> optVentas = this.ventasDao.findById(idComprobate);
        if (optVentas.isPresent()){
            try {
                final Ventas ventas = optVentas.get();
                final File file = ResourceUtils.getFile("classpath:ReportePDF.jrxml");
                final JasperReport report = (JasperReport) JRLoader.loadObject(file);

                final HashMap<String, Object> parameters = new HashMap<>();

                JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
                byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);
                String sdf = (new SimpleDateFormat("dd/MM/YYYY")).format(new Date());
                StringBuilder stringBuilder = new StringBuilder().append("InvoicePDF:");
                ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
                        .filename(stringBuilder.append(ventas.getIdComprobante())
                                .append("generateDate:")
                                .append(sdf)
                                .append(".pdf")
                                .toString())
                        .build();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentDisposition(contentDisposition);
                return ResponseEntity.ok().contentLength((long)reporte.length)
                        .contentType(MediaType.APPLICATION_PDF)
                        .headers(headers).body(new ByteArrayResource(reporte));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            return ResponseEntity.noContent().build(); //por si no se encuentra el reporte
        }
        return null;
    }

}
