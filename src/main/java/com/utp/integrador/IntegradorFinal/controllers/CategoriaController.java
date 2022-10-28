package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.utp.integrador.IntegradorFinal.models.entity.Categoria;
import com.utp.integrador.IntegradorFinal.services.CategoriaService;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    
    @PostMapping("/guardarCategoria")
    public String save(Categoria categoria) {
        categoriaService.guardar(categoria);
        
        return "redirect:/almacen#IrVentanaCategoria";
    }
}
