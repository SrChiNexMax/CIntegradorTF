package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.utp.integrador.IntegradorFinal.models.entity.Empleado;
import com.utp.integrador.IntegradorFinal.services.EmpleadoService;


@Controller
public class UsuariosController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	
	@GetMapping("/usuarios")
	public String usuariosMainPage(Model model) {
		var empleado = empleadoService.listarEmpleados();
		model.addAttribute("usuarios", empleado);
		
		return "secciones/usuarios";
	}
	
	@PostMapping("/guardarUsuario")
	public String save(Empleado empleado) {
		empleadoService.guardar(empleado);
		
		return "redirect:/usuarios";
	}
	
	/*
	 * @GetMapping("/eliminarUsuario") public String eliminarUsuario(Empleado
	 * empleado){ empleadoService.eliminar(empleado); return "redirect:/usuarios"; }
	 */
	
}
