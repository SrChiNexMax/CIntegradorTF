package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlmacenController {
	
	@GetMapping("/almacen")
	public String mainPage(Model model) {
		
		return "secciones/almacen";
	}

}
