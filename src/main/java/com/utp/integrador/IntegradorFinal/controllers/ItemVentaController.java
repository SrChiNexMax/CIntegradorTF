package com.utp.integrador.IntegradorFinal.controllers;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String consegirVenta(@PathVariable(name = "id") Long id, RedirectAttributes redirectAttributes,
            @Param("dniRuc") Integer dniRuc, @Param("idPro") Long idPro, @Param("idProducto") Long idProducto,
            @Param("cantidad") Integer cantidad, @Param("idCliente") Long idCliente,
            @RequestParam(required = false, name = "importe") String importe,
            @RequestParam(required = false, name = "tipodeComprobante") String tipodeComprobante) {

        Ventas venta = ventaService.encontrarVentaPorId(id);
        redirectAttributes.addFlashAttribute("ven", venta);

        Long idComprobante = venta.getIdComprobante();
        var items = detalleVentaService.listarDetalleVenta(idComprobante);
        redirectAttributes.addFlashAttribute("items", items);

        Cliente cliente = venta.getCliente();
        dniRuc = cliente.getDniRuc();
        redirectAttributes.addFlashAttribute("dniRuc", dniRuc);

        var clientes = clienteService.encontrarUnCliente(dniRuc);
        redirectAttributes.addFlashAttribute("clientes", clientes);

        redirectAttributes.addFlashAttribute("idPro", idPro);
        Producto productos = productoService.encontrarUnProducto(idPro);
        redirectAttributes.addFlashAttribute("productos", productos);

        idProducto = idPro;
        redirectAttributes.addFlashAttribute("idProducto", idProducto);

        redirectAttributes.addFlashAttribute("idCliente", idCliente);
        redirectAttributes.addFlashAttribute("importe", importe);
        redirectAttributes.addFlashAttribute("tipodeComprobante", tipodeComprobante);

        return "redirect:/nuevaVentas";
    }

    @RequestMapping(value = "/nuevaVentas", method = RequestMethod.GET)
    public String nuevaVentasMainPage(Model model) {

        model.addAttribute("venta", model.getAttribute("ven"));

        return "secciones/nuevaVentas";
    }

    @RequestMapping(value = "/busqueda/{id}", method = RequestMethod.GET)
    public String busqueda(@PathVariable(name = "id") Long id, @Param("dniRuc") Integer dniRuc,
            @Param("idPro") Long idPro, @Param("idProducto") Long idProducto, @Param("cantidad") Integer cantidad,
            RedirectAttributes redirectAttributes, @Param("idCliente") Long idCliente,
            @RequestParam(required = false, name = "importe") String importe,
            @RequestParam(required = false, name = "tipodeComprobante") String tipodeComprobante) {

        if(!clienteService.existeClientePorDni(dniRuc)){
            redirectAttributes.addFlashAttribute("msg", "No se encontro el cliente");

            Ventas venta = ventaService.encontrarVentaPorId(id);
            redirectAttributes.addFlashAttribute("ven", venta);

            Long idComprobante = venta.getIdComprobante();
            var items = detalleVentaService.listarDetalleVenta(idComprobante);
            redirectAttributes.addFlashAttribute("items", items);

            Cliente clientes = clienteService.encontrarUnCliente(1);
            redirectAttributes.addFlashAttribute("clientes", clientes);
            redirectAttributes.addFlashAttribute("dniRuc", dniRuc);

            redirectAttributes.addFlashAttribute("idPro", 1);
            Producto productos = productoService.encontrarUnProducto(1L);
            redirectAttributes.addFlashAttribute("productos", productos);

            idProducto = 1L;
            redirectAttributes.addFlashAttribute("idProducto", idProducto);

            Long cli = clientes.getIdCliente();
            redirectAttributes.addFlashAttribute("idCliente", cli);
            redirectAttributes.addFlashAttribute("importe", importe);
            redirectAttributes.addFlashAttribute("tipodeComprobante", tipodeComprobante);
            return "redirect:/nuevaVentas";
        }
        if(!productoService.existeProductoPorId(idPro)){
            redirectAttributes.addFlashAttribute("msg3", "No se encontro el producto");
            
            Ventas venta = ventaService.encontrarVentaPorId(id);
            redirectAttributes.addFlashAttribute("ven", venta);

            Long idComprobante = venta.getIdComprobante();
            var items = detalleVentaService.listarDetalleVenta(idComprobante);
            redirectAttributes.addFlashAttribute("items", items);

            Cliente clientes = clienteService.encontrarUnCliente(1);
            redirectAttributes.addFlashAttribute("clientes", clientes);
            redirectAttributes.addFlashAttribute("dniRuc", dniRuc);

            redirectAttributes.addFlashAttribute("idPro", 1);
            Producto productos = productoService.encontrarUnProducto(1L);
            redirectAttributes.addFlashAttribute("productos", productos);

            idProducto = 1L;
            redirectAttributes.addFlashAttribute("idProducto", idProducto);

            Long cli = clientes.getIdCliente();
            redirectAttributes.addFlashAttribute("idCliente", cli);
            redirectAttributes.addFlashAttribute("importe", importe);
            redirectAttributes.addFlashAttribute("tipodeComprobante", tipodeComprobante);
            return "redirect:/nuevaVentas";
        }

        Ventas venta = ventaService.encontrarVentaPorId(id);
        redirectAttributes.addFlashAttribute("ven", venta);

        Long idComprobante = venta.getIdComprobante();
        var items = detalleVentaService.listarDetalleVenta(idComprobante);
        redirectAttributes.addFlashAttribute("items", items);

        Cliente clientes = clienteService.encontrarUnCliente(dniRuc);
        redirectAttributes.addFlashAttribute("clientes", clientes);
        redirectAttributes.addFlashAttribute("dniRuc", dniRuc);

        redirectAttributes.addFlashAttribute("idPro", idPro);
        Producto productos = productoService.encontrarUnProducto(idPro);
        redirectAttributes.addFlashAttribute("productos", productos);

        idProducto = idPro;
        redirectAttributes.addFlashAttribute("idProducto", idProducto);

        Long cli = clientes.getIdCliente();
        redirectAttributes.addFlashAttribute("idCliente", cli);
        redirectAttributes.addFlashAttribute("importe", importe);
        redirectAttributes.addFlashAttribute("tipodeComprobante", tipodeComprobante);

        return "redirect:/nuevaVentas";
    }

    @RequestMapping(value = "/agregarItem/{id}/{id2}", method = RequestMethod.POST)
    public String agregarItem(@PathVariable(name = "id") Long id, @PathVariable(name = "id2") Long id2,
            @Param("dniRuc") Integer dniRuc, @Param("idPro") Long idPro, @Param("idProducto") Long idProducto,
            @Param("cantidad") Integer cantidad, RedirectAttributes redirectAttributes,
            @Param("idCliente") Long idCliente, @RequestParam(required = false, name = "importe") String importe,
            @RequestParam(required = false, name = "tipodeComprobante") String tipodeComprobante) {

        Ventas venta = ventaService.encontrarVentaPorId(id);
        redirectAttributes.addFlashAttribute("ven", venta);

        Producto producto = productoService.encontrarUnProducto(id2);
        redirectAttributes.addFlashAttribute("idProducto", idProducto);

        productoService.modificarStock(producto.getIdProducto(), producto.getUnidadesExistentes() - cantidad);
        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setVentas(venta);
        detalleVenta.setProducto(producto);
        detalleVenta.setPrecioUnidad(producto.getPrecioUnidad());
        detalleVenta.setCantidad(cantidad);
        detalleVentaService.guardar(detalleVenta);

        Long idComprobante = venta.getIdComprobante();
        var items = detalleVentaService.listarDetalleVenta(idComprobante);
        redirectAttributes.addFlashAttribute("items", items);

        var clientes = clienteService.encontrarUnCliente(dniRuc);
        redirectAttributes.addFlashAttribute("clientes", clientes);
        redirectAttributes.addFlashAttribute("dniRuc", dniRuc);

        redirectAttributes.addFlashAttribute("idPro", idPro);
        var productos = productoService.encontrarUnProducto(idPro);
        redirectAttributes.addFlashAttribute("productos", productos);

        redirectAttributes.addFlashAttribute("idCliente", idCliente);
        redirectAttributes.addFlashAttribute("importe", importe);
        redirectAttributes.addFlashAttribute("tipoComprobante", tipodeComprobante);

        return "redirect:/nuevaVentas";
    }

    @RequestMapping(value = "/modificarVenta/{id}", method = RequestMethod.GET)
    public String modificarVenta(@PathVariable(name = "id") Long id, @Param("dniRuc") Integer dniRuc,
            @Param("idPro") Long idPro, @Param("idProducto") Long idProducto, @Param("cantidad") Integer cantidad,
            RedirectAttributes redirectAttributes, @Param("idCliente") Long idCliente,
            @RequestParam(required = false, name = "importe") String importe,
            @RequestParam(required = false, name = "tipodeComprobante") String tipodeComprobante) {

        if(!clienteService.existeClientePorId(idCliente)){
            redirectAttributes.addFlashAttribute("msg2", "No se encontro el cliente");

            Cliente clientes = clienteService.encontrarUnCliente(1);

            Ventas venta = ventaService.encontrarVentaPorId(id);
            redirectAttributes.addFlashAttribute("ven", venta);

            redirectAttributes.addFlashAttribute("idProducto", idProducto);

            Long idComprobante = venta.getIdComprobante();
            var items = detalleVentaService.listarDetalleVenta(idComprobante);
            redirectAttributes.addFlashAttribute("items", items);

            redirectAttributes.addFlashAttribute("clientes", clientes);
            redirectAttributes.addFlashAttribute("dniRuc", dniRuc);

            redirectAttributes.addFlashAttribute("idPro", idPro);
            var productos = productoService.encontrarUnProducto(idPro);
            redirectAttributes.addFlashAttribute("productos", productos);

            redirectAttributes.addFlashAttribute("idCliente", idCliente);
            redirectAttributes.addFlashAttribute("importe", importe);
            redirectAttributes.addFlashAttribute("tipodeComprobante", tipodeComprobante);

            return "redirect:/nuevaVentas";
        }
            
        Cliente clientes = clienteService.encontrarUnCliente(dniRuc);

        Cliente c = clienteService.encontrarClientePorId(idCliente);
        BigDecimal bd = new BigDecimal(importe);
        ventaService.editar(id, c, tipodeComprobante, bd);

        Ventas venta = ventaService.encontrarVentaPorId(id);
        redirectAttributes.addFlashAttribute("ven", venta);

        redirectAttributes.addFlashAttribute("idProducto", idProducto);

        Long idComprobante = venta.getIdComprobante();
        var items = detalleVentaService.listarDetalleVenta(idComprobante);
        redirectAttributes.addFlashAttribute("items", items);

        redirectAttributes.addFlashAttribute("clientes", clientes);
        redirectAttributes.addFlashAttribute("dniRuc", dniRuc);

        redirectAttributes.addFlashAttribute("idPro", idPro);
        var productos = productoService.encontrarUnProducto(idPro);
        redirectAttributes.addFlashAttribute("productos", productos);

        redirectAttributes.addFlashAttribute("idCliente", idCliente);
        redirectAttributes.addFlashAttribute("importe", importe);
        redirectAttributes.addFlashAttribute("tipodeComprobante", tipodeComprobante);

        return "redirect:/nuevaVentas";
    }

    @RequestMapping(value = "/eliminarItem/{id}/{id2}", method = RequestMethod.GET)
    public String eliminarItem(@PathVariable(name = "id") Long id, @PathVariable(name = "id2") Long id2,
            @Param("dniRuc") Integer dniRuc, @Param("idPro") Long idPro, @Param("idProducto") Long idProducto,
            @Param("cantidad") Integer cantidad, RedirectAttributes redirectAttributes,
            @Param("idCliente") Long idCliente, @RequestParam(required = false, name = "importe") String importe,
            @RequestParam(required = false, name = "tipodeComprobante") String tipodeComprobante) {

        Ventas venta = ventaService.encontrarVentaPorId(id);
        redirectAttributes.addFlashAttribute("ven", venta);

        DetalleVenta detalleVenta = detalleVentaService.encontrarUnDetalleVenta(id2);
        Producto producto = detalleVenta.getProducto();
        Integer cant = detalleVenta.getCantidad();
        productoService.modificarStock(producto.getIdProducto(), producto.getUnidadesExistentes() + cant);

        detalleVentaService.eliminar(id2);

        Long idComprobante = venta.getIdComprobante();
        var items = detalleVentaService.listarDetalleVenta(idComprobante);
        redirectAttributes.addFlashAttribute("items", items);

        var clientes = clienteService.encontrarUnCliente(dniRuc);
        redirectAttributes.addFlashAttribute("clientes", clientes);
        redirectAttributes.addFlashAttribute("dniRuc", dniRuc);

        redirectAttributes.addFlashAttribute("idPro", idPro);
        var productos = productoService.encontrarUnProducto(idPro);
        redirectAttributes.addFlashAttribute("productos", productos);

        Long cli = clientes.getIdCliente();
        redirectAttributes.addFlashAttribute("idCliente", cli);
        redirectAttributes.addFlashAttribute("importe", importe);
        redirectAttributes.addFlashAttribute("tipodeComprobante", tipodeComprobante);

        return "redirect:/nuevaVentas";
    }

    @RequestMapping(value = "/editarItem/{id}/{id2}", method = RequestMethod.GET)
    public String editarItem(Model model, @PathVariable(name = "id") Long id, @PathVariable(name = "id2") Long id2,
            @Param("dniRuc") Integer dniRuc, @Param("idPro") Long idPro, @Param("idProducto") Long idProducto,
            @Param("cantidad") Integer cantidad, @Param("cant") Integer cant, @Param("idCliente") Long idCliente,
            @RequestParam(required = false, name = "importe") String importe,
            @RequestParam(required = false, name = "tipodeComprobante") String tipodeComprobante) {

        Ventas venta = ventaService.encontrarVentaPorId(id);
        model.addAttribute("ven", venta);

        DetalleVenta detalleVenta = detalleVentaService.encontrarUnDetalleVenta(id2);
        Producto producto = detalleVenta.getProducto();
        Integer c = detalleVenta.getCantidad();
        productoService.modificarStock(producto.getIdProducto(), producto.getUnidadesExistentes() + c);

        model.addAttribute("id2", id2);
        model.addAttribute("produc", producto);
        model.addAttribute("cant", c);

        Long idComprobante = venta.getIdComprobante();
        var items = detalleVentaService.listarDetalleVenta(idComprobante);
        model.addAttribute("items", items);

        var clientes = clienteService.encontrarUnCliente(dniRuc);
        model.addAttribute("clientes", clientes);
        model.addAttribute("dniRuc", dniRuc);

        model.addAttribute("idPro", idPro);
        var productos = productoService.encontrarUnProducto(idPro);
        model.addAttribute("productos", productos);
        model.addAttribute("cantidad", cantidad);

        Long cli = clientes.getIdCliente();
        model.addAttribute("idCliente", cli);
        model.addAttribute("importe", importe);
        model.addAttribute("tipodeComprobante", tipodeComprobante);

        return "secciones/editarItem";
    }

    @RequestMapping(value = "/cancelarEdit/{id}/{id2}", method = RequestMethod.GET)
    public String cancelarEdicion(@PathVariable(name = "id") Long id, @PathVariable(name = "id2") Long id2,
            @Param("dniRuc") Integer dniRuc, @Param("idPro") Long idPro, @Param("idProducto") Long idProducto,
            @Param("cantidad") Integer cantidad, RedirectAttributes redirectAttributes,
            @Param("idCliente") Long idCliente, @RequestParam(required = false, name = "importe") String importe,
            @RequestParam(required = false, name = "tipodeComprobante") String tipodeComprobante) {

        Ventas venta = ventaService.encontrarVentaPorId(id);
        redirectAttributes.addFlashAttribute("ven", venta);

        DetalleVenta detalleVenta = detalleVentaService.encontrarUnDetalleVenta(id2);
        Producto producto = detalleVenta.getProducto();
        Integer c = detalleVenta.getCantidad();
        productoService.modificarStock(producto.getIdProducto(), producto.getUnidadesExistentes() - c);

        Long idComprobante = venta.getIdComprobante();
        var items = detalleVentaService.listarDetalleVenta(idComprobante);
        redirectAttributes.addFlashAttribute("items", items);

        var clientes = clienteService.encontrarUnCliente(dniRuc);
        redirectAttributes.addFlashAttribute("clientes", clientes);
        redirectAttributes.addFlashAttribute("dniRuc", dniRuc);

        redirectAttributes.addFlashAttribute("idPro", idPro);
        var productos = productoService.encontrarUnProducto(idPro);
        redirectAttributes.addFlashAttribute("productos", productos);

        Long cli = clientes.getIdCliente();
        redirectAttributes.addFlashAttribute("idCliente", cli);
        redirectAttributes.addFlashAttribute("importe", importe);
        redirectAttributes.addFlashAttribute("tipodeComprobante", tipodeComprobante);

        return "redirect:/nuevaVentas";
    }

    @RequestMapping(value = "/aceptarEdit/{id}/{id2}", method = RequestMethod.POST)
    public String aceptarEdicion(@PathVariable(name = "id") Long id, @PathVariable(name = "id2") Long id2,
            @Param("dniRuc") Integer dniRuc, @Param("idPro") Long idPro, @Param("idProducto") Long idProducto,
            @Param("cantidad") Integer cantidad, @Param("cant") Integer cant, RedirectAttributes redirectAttributes,
            @Param("idCliente") Long idCliente, @RequestParam(required = false, name = "importe") String importe,
            @RequestParam(required = false, name = "tipodeComprobante") String tipodeComprobante) {

        Ventas venta = ventaService.encontrarVentaPorId(id);
        redirectAttributes.addFlashAttribute("ven", venta);

        DetalleVenta detalleVenta = detalleVentaService.encontrarUnDetalleVenta(id2);
        Producto producto = detalleVenta.getProducto();
        productoService.modificarStock(producto.getIdProducto(), producto.getUnidadesExistentes() - cant);
        detalleVenta.setCantidad(cant);
        detalleVentaService.guardar(detalleVenta);

        Long idComprobante = venta.getIdComprobante();
        var items = detalleVentaService.listarDetalleVenta(idComprobante);
        redirectAttributes.addFlashAttribute("items", items);

        var clientes = clienteService.encontrarUnCliente(dniRuc);
        redirectAttributes.addFlashAttribute("clientes", clientes);
        redirectAttributes.addFlashAttribute("dniRuc", dniRuc);

        redirectAttributes.addFlashAttribute("idPro", idPro);
        var productos = productoService.encontrarUnProducto(idPro);
        redirectAttributes.addFlashAttribute("productos", productos);

        Long cli = clientes.getIdCliente();
        redirectAttributes.addFlashAttribute("idCliente", cli);
        redirectAttributes.addFlashAttribute("importe", importe);
        redirectAttributes.addFlashAttribute("tipodeComprobante", tipodeComprobante);
        return "redirect:/nuevaVentas";
    }

    @RequestMapping(value = "/finalizarVenta/{id}", method = RequestMethod.GET)
    public String finalizarVenta(@PathVariable(name = "id") Long id, @Param("dniRuc") Integer dniRuc,
            @Param("idPro") Long idPro, @Param("idProducto") Long idProducto, @Param("cantidad") Integer cantidad,
            RedirectAttributes redirectAttributes, @Param("idCliente") Long idCliente,
            @RequestParam(required = false, name = "importefinal") String importefinal,
            @RequestParam(required = false, name = "tipodeComprobante") String tipodeComprobante) {

        BigDecimal bd = new BigDecimal(importefinal);
        Timestamp t = new Timestamp(new Date().getTime());
        ventaService.finalizar(id, bd, t);

        return "redirect:/ventas";
    }
}
