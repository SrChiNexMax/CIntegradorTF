package com.utp.integrador.IntegradorFinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.utp.integrador.IntegradorFinal.models.dao.VentasDao;
import com.utp.integrador.IntegradorFinal.models.entity.Ventas;
import com.utp.integrador.IntegradorFinal.services.VentaService;

@Controller
public class CajaController {

	@Autowired
	private VentaService ventaService;
	
	@GetMapping("/caja")
	public String cajaMainPage(Model model) {
		
		List<Ventas> ventas = ventaService.encontrarVentasPorFacturado();
		model.addAttribute("ventas", ventas);
		
		return "secciones/caja";
	}
	
	
	
	
}
