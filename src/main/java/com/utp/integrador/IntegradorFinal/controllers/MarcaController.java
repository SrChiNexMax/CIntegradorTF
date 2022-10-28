package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;

import com.utp.integrador.IntegradorFinal.models.entity.Marca;
import com.utp.integrador.IntegradorFinal.services.MarcaService;

@Controller
public class MarcaController {
    
    @Autowired
    private MarcaService marcaService;

    
    @PostMapping("/guardarMarca")
    public String save(Marca marca) {
        marcaService.guardar(marca);
        
        return "redirect:/almacen#IrVentanaMarca";
    }
}
