package com.utp.integrador.IntegradorFinal.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.integrador.IntegradorFinal.models.dao.ProductoDao;
import com.utp.integrador.IntegradorFinal.models.entity.Producto;
import com.utp.integrador.IntegradorFinal.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
    
    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listarProductos(String palabraClave) {
        if(palabraClave != null){
            return (List<Producto>) productoDao.filtrarProductos(palabraClave);
        }
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Producto producto) {
        productoDao.save(producto);
        
    }

    @Override
    @Transactional(readOnly = true)
    public Producto encontrarProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto encontrarUnProducto(Long palabraClave) {
        if(palabraClave != null){
            return productoDao.unProducto(palabraClave);
        }
        return productoDao.unProducto(Long.parseLong("1"));
    }

    @Override
    @Transactional
    public void modificarStock(Long idProducto, Integer stock){
        productoDao.modificarStock(idProducto, stock);
    }

    @Override
	@Transactional(readOnly = true)
    public boolean existeProductoPorId(Long idProducto){
        return productoDao.existsByIdProducto(idProducto);
    }

}
