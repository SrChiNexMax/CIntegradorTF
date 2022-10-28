package com.utp.integrador.IntegradorFinal.services;

import java.util.List;

import com.utp.integrador.IntegradorFinal.models.entity.Categoria;

public interface CategoriaService {

    public List<Categoria> listarCategorias();
    
    public void guardar(Categoria categoria);
    
    public Categoria encontrarCategoria(Categoria categoria);
}
