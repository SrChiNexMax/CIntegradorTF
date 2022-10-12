package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String mainPage(Model model) {
		model.addAttribute("mensaje", "Mensaje desde model"); 
		
		return "index";
	}

}
