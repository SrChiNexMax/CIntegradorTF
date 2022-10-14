package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuariosController {
	
	@GetMapping("/usuarios")
	public String usuariosMainPage(Model model) {
		
		return "secciones/usuarios";
	}
}
