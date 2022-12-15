package com.utp.integrador.IntegradorFinal.controllers;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utp.integrador.IntegradorFinal.models.entity.Liquidacion;
import com.utp.integrador.IntegradorFinal.models.entity.Ventas;
import com.utp.integrador.IntegradorFinal.services.DetalleVentaService;
import com.utp.integrador.IntegradorFinal.services.LiquidacionService;
import com.utp.integrador.IntegradorFinal.services.VentaService;
import com.utp.integrador.IntegradorFinal.util.Utils;

@Controller
public class CajaController {

	@Autowired
	private LiquidacionService liquidacionService;

	@Autowired
	private VentaService ventaService;

	@Autowired
	private DetalleVentaService detalleVentaService;
	
	@GetMapping("/caja")
	public String cajaMainPage(Model model) {
		
		var ventas = ventaService.encontrarVentasPorFacturadoAndLiquidado();
		var dv = detalleVentaService.listarDVporLiquidado();
		var li = liquidacionService.listarLiquidacion();
		var imDv = dv;
		imDv.forEach(detalleVenta -> {
			detalleVenta.getVentas().setDetalleVentas(null);
		});
		Utils.prettyPrintObject(imDv);
		model.addAttribute("ventas", ventas);
		model.addAttribute("detalle",dv);
		model.addAttribute("liquidacion", li);
		
		return "secciones/caja";
	}
	
	@GetMapping("/desfacturar/{id}")
	public String desfacturarVenta(@PathVariable(name="id") Long id) {
		Ventas venta = ventaService.encontrarVentaPorId(id);
		venta.setFacturado(false);
		ventaService.guardar(venta);
		
		return "redirect:/caja";
	}

	@GetMapping("/observarVenta/{id}")
	public String observarMainPage(Model model, @PathVariable(name = "id")Long id) {
		
		Ventas venta = ventaService.encontrarVentaPorId(id);
		model.addAttribute("venta", venta);
		
		Long idComprobante = venta.getIdComprobante();
		var items = detalleVentaService.listarDetalleVenta(idComprobante);
		model.addAttribute("items", items);
		
		return "secciones/visualizarVenta";
	}

	@RequestMapping("/liquidar")
	public String liquidarVenta() {
		List<Ventas> ventasf = ventaService.encontrarVentasPorFacturadoAndLiquidado();
		BigDecimal sumTL = BigDecimal.valueOf(0.0);
		for (Ventas v: ventasf){
			v.setLiquidado(true);
			sumTL=sumTL.add(v.getImporte());
		}
		ventaService.guardarLiquidadas(ventasf);
		Liquidacion liquidacion = new Liquidacion();
		Timestamp t = new Timestamp(new Date().getTime());
		liquidacion.setTotal(sumTL);
		liquidacion.setFechaVenta(t);
		liquidacionService.guardarLiquidacion(liquidacion);
		return "redirect:/caja";
	}
	
	
}
