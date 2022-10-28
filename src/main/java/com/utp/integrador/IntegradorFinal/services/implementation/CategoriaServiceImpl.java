package com.utp.integrador.IntegradorFinal.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.integrador.IntegradorFinal.models.dao.CategoriaDao;
import com.utp.integrador.IntegradorFinal.models.entity.Categoria;
import com.utp.integrador.IntegradorFinal.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    
    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> listarCategorias() {
        return (List<Categoria>) categoriaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Categoria categoria) {
        categoriaDao.save(categoria);
        
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria encontrarCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

}
