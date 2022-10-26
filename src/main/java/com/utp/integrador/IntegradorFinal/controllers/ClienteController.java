package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.utp.integrador.IntegradorFinal.models.entity.Cliente;
import com.utp.integrador.IntegradorFinal.services.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/clientes")
	public String clientesMainPage(Model model) {
		var clientes = clienteService.listarClientes();
		model.addAttribute("clientes", clientes);

		return "secciones/clientes";
	}
	
	@PostMapping("/guardarCliente")
	public String save(Cliente cliente){
		clienteService.guardar(cliente);

		return "redirect:/clientes";
	}

	@GetMapping("/eliminarCliente")
	public String eliminarCliente(Cliente cliente){
		clienteService.eliminar(cliente);
		
		return "redirect:/clientes";
	}
}
