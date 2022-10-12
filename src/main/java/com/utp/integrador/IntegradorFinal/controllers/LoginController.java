package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.utp.integrador.IntegradorFinal.services.PersonaService;

@Controller
public class LoginController {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/")
	public String mainPage(Model model) {
		var personas = personaService.listarPersonas();
		model.addAttribute("personas", personas); 
		
		return "index";
	}

}
