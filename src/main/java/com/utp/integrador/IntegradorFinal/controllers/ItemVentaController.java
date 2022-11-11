package com.utp.integrador.IntegradorFinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.utp.integrador.IntegradorFinal.services.ClienteService;
import com.utp.integrador.IntegradorFinal.services.ProductoService;

@Controller
public class ItemVentaController {
    
    @Autowired
	private ClienteService clienteService;

    @Autowired
    public ProductoService productoService;

    @GetMapping("/nuevaVentas")
    public String nuevaVentasMainPage(Model model,@Param("dniRuc") Integer dniRuc,@Param("idPro") Long idPro, @Param("idProducto") Long idProducto){

        model.addAttribute("dniRuc", dniRuc);
        var clientes = clienteService.encontrarUnCliente(dniRuc);
		model.addAttribute("clientes", clientes);

        model.addAttribute("idPro", idPro);
        var productos = productoService.encontrarUnProducto(idPro);
        model.addAttribute("productos", productos);

        idProducto=idPro;
        model.addAttribute("idProducto", idProducto);
        
        return "secciones/nuevaVentas";
    }
}
