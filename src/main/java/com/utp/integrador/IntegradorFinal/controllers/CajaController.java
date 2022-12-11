package com.utp.integrador.IntegradorFinal.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.utp.integrador.IntegradorFinal.models.entity.Ventas;
import com.utp.integrador.IntegradorFinal.services.DetalleVentaService;
import com.utp.integrador.IntegradorFinal.services.VentaService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CajaController {

	@Autowired
	private VentaService ventaService;

	@Autowired
	private DetalleVentaService detalleVentaService;
	
	@GetMapping("/caja")
	public String cajaMainPage(Model model) {
		
		List<Ventas> ventas = ventaService.encontrarVentasPorFacturado();
		model.addAttribute("ventas", ventas);
		
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

	@PostMapping("/liquidar")
	public String liquidarVenta() {
		List<Ventas> ventasf = ventaService.encontrarVentasPorFacturadoAndLiquidado();
		BigDecimal sumTL = BigDecimal.valueOf(0.0);
		for (Ventas v: ventasf){
			v.setLiquidado(true);
			sumTL=sumTL.add(v.getImporte());
		}
		ventaService.guardarLiquidadas(ventasf);
		return "redirect:/caja";
	}
	
	
}
