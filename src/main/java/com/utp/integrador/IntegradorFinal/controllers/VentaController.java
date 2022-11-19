package com.utp.integrador.IntegradorFinal.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.utp.integrador.IntegradorFinal.models.entity.Cliente;
import com.utp.integrador.IntegradorFinal.models.entity.Empleado;
import com.utp.integrador.IntegradorFinal.models.entity.Ventas;
import com.utp.integrador.IntegradorFinal.services.ClienteService;
import com.utp.integrador.IntegradorFinal.services.EmpleadoService;
import com.utp.integrador.IntegradorFinal.services.VentaService;

@Controller
public class VentaController {
	
	@Autowired
	private VentaService ventaService;

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/ventas")
	public String ventasMainPage(Model model) {
		
		var ventas= ventaService.listarVentas();
		model.addAttribute("ventas", ventas);

		return "secciones/ventas";
	}

	@PostMapping("/nuevaVenta")
	public String nuevo(){
		
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

		String dni= "";

		Object principal= authentication.getPrincipal();
		if(principal instanceof UserDetails){
			dni= ((UserDetails) principal).getUsername();
		}else{
			dni= principal.toString();
		}

		Empleado e= empleadoService.encontrarUnEmpleado(dni);
		Cliente c= clienteService.encontrarClientePorId(1L);

		Ventas v= new Ventas();
		v.setEmpleado(e);
		v.setCliente(c);
		
		ventaService.guardar(v);

		return "redirect:/ventas";
	}
	
	@RequestMapping("/eliminarVenta/{id}")
	public String eliminarVenta(@PathVariable(name="id") Long id){
		ventaService.eliminar(id);
		return "redirect:/ventas";
	}
}
