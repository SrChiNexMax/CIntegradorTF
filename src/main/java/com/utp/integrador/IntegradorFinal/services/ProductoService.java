package com.utp.integrador.IntegradorFinal.services;

import java.util.List;

import com.utp.integrador.IntegradorFinal.models.entity.Producto;

public interface ProductoService {
    
public List<Producto> listarProductos();
    
    public void guardar(Producto producto);
    
    public Producto encontrarProducto(Producto producto);
}
