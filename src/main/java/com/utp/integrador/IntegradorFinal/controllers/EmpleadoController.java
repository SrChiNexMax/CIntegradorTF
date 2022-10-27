package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.utp.integrador.IntegradorFinal.models.entity.Empleado;
import com.utp.integrador.IntegradorFinal.services.EmpleadoService;

@Controller
public class EmpleadoController {
    
    @Autowired
    private EmpleadoService empleadoService;
    
    
    @GetMapping("/empleados")
    public String empleadosMainPage(Model model) {
        var empleado = empleadoService.listarEmpleados();
        model.addAttribute("empleado", empleado);
        
        return "secciones/empleados";
    }
    
    @PostMapping("/guardarEmpleado")
    public String save(Empleado empleado) {
        empleadoService.guardar(empleado);
        
        return "redirect:/empleados";
    }

}
