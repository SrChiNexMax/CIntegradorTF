package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuariosController {
	
	@GetMapping
	public String mainPage(Model model) {
		
		return "secciones/usuarios";
	}
}
