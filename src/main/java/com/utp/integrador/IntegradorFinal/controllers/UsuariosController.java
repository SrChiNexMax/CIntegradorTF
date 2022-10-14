package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.utp.integrador.IntegradorFinal.services.UsuarioService;

@Controller
public class UsuariosController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/usuarios")
	public String usuariosMainPage(Model model) {
		var usuarios = usuarioService.listarUsuarios();
		model.addAttribute("usuarios", usuarios);
		
		return "secciones/usuarios";
	}
}
