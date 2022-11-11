package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

		String estado= "Laborando";

		var empleados = empleadoService.listarUsuarios(estado);
		model.addAttribute("empleados", empleados);
		model.addAttribute("emp", new Empleado());
		return "secciones/usuarios";
	}
	
	@PostMapping("/guardarUsuario")
	public String save(Empleado empleado) {

		if(empleado.getIdEmpleado() !=null){
			empleadoService.modificarUsuario(empleado);
			return "redirect:/usuarios";
		}

		empleadoService.registrarNuevoUsuario(empleado);
		return "redirect:/usuarios";
	}

	@PostMapping("/suspenderUsuario")
	public String suspender(@Param("idEmpleadoSus") Long idEmpleadoSus){

		String estado= "Suspendido";

		empleadoService.suspenderEmpleado(idEmpleadoSus, estado);

		return "redirect:/usuarios";
	}
	
	/*
	 * @GetMapping("/eliminarUsuario") public String eliminarUsuario(Empleado
	 * empleado){ empleadoService.eliminar(empleado); return "redirect:/usuarios"; }
	 */
	
}
