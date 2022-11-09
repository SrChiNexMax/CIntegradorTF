package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.utp.integrador.IntegradorFinal.models.entity.Categoria;
import com.utp.integrador.IntegradorFinal.models.entity.Marca;
import com.utp.integrador.IntegradorFinal.models.entity.Producto;
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
	public String almacenMainPage(Model model,@Param("palabraClave") String palabraClave) {

        model.addAttribute("palabraClave", palabraClave);

	    var marcas = marcaService.listarMarcas();
        model.addAttribute("marcas", marcas);
        
        var categorias = categoriaService.listarCategorias();
        model.addAttribute("categorias", categorias);
        
        var productos = productoService.listarProductos(palabraClave);  
        model.addAttribute("productos", productos);
        
        Marca marca = new Marca();
        Categoria categoria = new Categoria();
        Producto producto = new Producto();
        producto.setMarca(marca);
        producto.setCategoria(categoria);
        
        model.addAttribute("productoNew", producto);
        model.addAttribute("marcaNew", marca);
        model.addAttribute("categoriaNew", categoria);
        
		return "secciones/almacen";
	}
}
