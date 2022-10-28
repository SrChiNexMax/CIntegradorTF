package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.utp.integrador.IntegradorFinal.services.CategoriaService;
import com.utp.integrador.IntegradorFinal.services.MarcaService;
import com.utp.integrador.IntegradorFinal.services.ProductoService;

@Controller
public class AlmacenController {
    
    @Autowired
    public MarcaService marcaService;
    
    @Autowired
    public CategoriaService categoriaService;
    
    @Autowired
    public ProductoService productoService;
	
	@GetMapping("/almacen")
	public String almacenMainPage(Model model) {
	    var marcas = marcaService.listarMarcas();
        model.addAttribute("marcas", marcas);
        
        var categorias = categoriaService.listarCategorias();
        model.addAttribute("categorias", categorias);
        
        var productos = productoService.listarProductos();
        model.addAttribute("productos", productos);
        
		return "secciones/almacen";
	}
}
