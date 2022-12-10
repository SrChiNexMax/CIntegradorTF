package com.utp.integrador.IntegradorFinal.services;

import java.util.List;

import com.utp.integrador.IntegradorFinal.models.entity.Producto;

public interface ProductoService {
    
    public List<Producto> listarProductos(String palabraClave);
    
    public void guardar(Producto producto);
    
    public Producto encontrarProducto(Producto producto);

    public Producto encontrarUnProducto(Long palabraClave);

    public void modificarStock(Long idProducto, Integer stock);

    public boolean existeProductoPorId(Long idProducto);
}
