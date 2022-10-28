package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.utp.integrador.IntegradorFinal.models.entity.Producto;
import com.utp.integrador.IntegradorFinal.services.ProductoService;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    
    @PostMapping("/guardarProducto")
    public String save(Producto producto) {
        productoService.guardar(producto);
        
        return "redirect:/almacen";
    }
}
