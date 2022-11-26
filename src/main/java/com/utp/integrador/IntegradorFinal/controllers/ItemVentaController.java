package com.utp.integrador.IntegradorFinal.controllers;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.utp.integrador.IntegradorFinal.models.entity.Cliente;
import com.utp.integrador.IntegradorFinal.models.entity.DetalleVenta;
import com.utp.integrador.IntegradorFinal.models.entity.Producto;
import com.utp.integrador.IntegradorFinal.models.entity.Ventas;
import com.utp.integrador.IntegradorFinal.services.ClienteService;
import com.utp.integrador.IntegradorFinal.services.DetalleVentaService;
import com.utp.integrador.IntegradorFinal.services.ProductoService;
import com.utp.integrador.IntegradorFinal.services.VentaService;

@Controller
public class ItemVentaController {
    
    @Autowired
	private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private VentaService ventaService;

    @Autowired
    private DetalleVentaService detalleVentaService;

  

    @RequestMapping(value = "/darVenta/{id}", method = RequestMethod.GET)
    public String consegirVenta(@PathVariable(name = "id") Long id, RedirectAttributes redirectAttributes,@Param("dniRuc") Integer dniRuc,@Param("idPro") Long idPro, @Param("idProducto") Long idProducto,@Param("cantidad") Integer cantidad){
        
        Ventas venta= ventaService.encontrarVentaPorId(id);
        redirectAttributes.addFlashAttribute("ven", venta);

        Long idComprobante=venta.getIdComprobante();
        var items= detalleVentaService.listarDetalleVenta(idComprobante);
        redirectAttributes.addFlashAttribute("items", items);

        Cliente cliente= venta.getCliente();
        dniRuc=cliente.getDniRuc();
        redirectAttributes.addFlashAttribute("dniRuc", dniRuc);
        
        var clientes = clienteService.encontrarUnCliente(dniRuc);
        redirectAttributes.addFlashAttribute("clientes", clientes);

        redirectAttributes.addFlashAttribute("idPro", idPro);
        Producto productos = productoService.encontrarUnProducto(idPro);
        redirectAttributes.addFlashAttribute("productos", productos);

        idProducto=idPro;
        redirectAttributes.addFlashAttribute("idProducto", idProducto);

        return "redirect:/nuevaVentas";
    }

    @RequestMapping(value = "/nuevaVentas", method = RequestMethod.GET)
    public String nuevaVentasMainPage(Model model){

        model.addAttribute("venta", model.getAttribute("ven"));
        
        return "secciones/nuevaVentas";
    }

    @RequestMapping(value = "/busqueda/{id}", method = RequestMethod.GET)
    public String busqueda(@PathVariable(name = "id") Long id,@Param("dniRuc") Integer dniRuc,@Param("idPro") Long idPro, @Param("idProducto") Long idProducto,@Param("cantidad") Integer cantidad,RedirectAttributes redirectAttributes){
        
        Ventas venta= ventaService.encontrarVentaPorId(id);
        redirectAttributes.addFlashAttribute("ven", venta);

        Long idComprobante=venta.getIdComprobante();
        var items= detalleVentaService.listarDetalleVenta(idComprobante);
        redirectAttributes.addFlashAttribute("items", items);

        redirectAttributes.addFlashAttribute("dniRuc", dniRuc);
        
        var clientes = clienteService.encontrarUnCliente(dniRuc);
        redirectAttributes.addFlashAttribute("clientes", clientes);

        redirectAttributes.addFlashAttribute("idPro", idPro);
        Producto productos = productoService.encontrarUnProducto(idPro);
        redirectAttributes.addFlashAttribute("productos", productos);

        idProducto=idPro;
        redirectAttributes.addFlashAttribute("idProducto", idProducto);

        return "redirect:/nuevaVentas";
    }

    @RequestMapping(value = "/agregarItem/{id}/{id2}", method = RequestMethod.POST)
    public String agregarItem(@PathVariable(name = "id") Long id,@PathVariable(name = "id2") Long id2,@Param("dniRuc") Integer dniRuc,@Param("idPro") Long idPro, @Param("idProducto") Long idProducto,@Param("cantidad") Integer cantidad,RedirectAttributes redirectAttributes){
        
        Ventas venta= ventaService.encontrarVentaPorId(id);
        redirectAttributes.addFlashAttribute("ven", venta);

        Producto producto= productoService.encontrarUnProducto(id2);
        redirectAttributes.addFlashAttribute("idProducto", idProducto);

        DetalleVenta detalleVenta= new DetalleVenta();
        detalleVenta.setVentas(venta);
        detalleVenta.setProducto(producto);
        detalleVenta.setPrecioUnidad(producto.getPrecioUnidad());
        detalleVenta.setCantidad(cantidad);
        detalleVentaService.guardar(detalleVenta);

        Long idComprobante=venta.getIdComprobante();
        var items= detalleVentaService.listarDetalleVenta(idComprobante);
        redirectAttributes.addFlashAttribute("items", items);
        
        redirectAttributes.addFlashAttribute("dniRuc", dniRuc);
        
        var clientes = clienteService.encontrarUnCliente(dniRuc);
        redirectAttributes.addFlashAttribute("clientes", clientes);

        redirectAttributes.addFlashAttribute("idPro", idPro);
        var productos = productoService.encontrarUnProducto(idPro);
        redirectAttributes.addFlashAttribute("productos", productos);

        return "redirect:/nuevaVentas";
    }

    @RequestMapping(value = "/eliminarItem/{id}/{id2}", method = RequestMethod.GET)
    public String eliminarItem(@PathVariable(name = "id") Long id,@PathVariable(name = "id2") Long id2,@Param("dniRuc") Integer dniRuc,@Param("idPro") Long idPro, @Param("idProducto") Long idProducto,@Param("cantidad") Integer cantidad,RedirectAttributes redirectAttributes){
        
        Ventas venta= ventaService.encontrarVentaPorId(id);
        redirectAttributes.addFlashAttribute("ven", venta);

        detalleVentaService.eliminar(id2);

        Long idComprobante=venta.getIdComprobante();
        var items= detalleVentaService.listarDetalleVenta(idComprobante);
        redirectAttributes.addFlashAttribute("items", items);
        
        redirectAttributes.addFlashAttribute("dniRuc", dniRuc);
        
        var clientes = clienteService.encontrarUnCliente(dniRuc);
        redirectAttributes.addFlashAttribute("clientes", clientes);

        redirectAttributes.addFlashAttribute("idPro", idPro);
        var productos = productoService.encontrarUnProducto(idPro);
        redirectAttributes.addFlashAttribute("productos", productos);

        return "redirect:/nuevaVentas";
    }
}
