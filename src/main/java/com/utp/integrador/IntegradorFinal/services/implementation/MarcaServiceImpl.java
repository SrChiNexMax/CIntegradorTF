package com.utp.integrador.IntegradorFinal.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.integrador.IntegradorFinal.models.dao.MarcaDao;
import com.utp.integrador.IntegradorFinal.models.entity.Marca;
import com.utp.integrador.IntegradorFinal.services.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService{
    
    @Autowired
    private MarcaDao marcaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Marca> listarMarcas() {
        return (List<Marca>) marcaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Marca marca) {
        marcaDao.save(marca);
        
    }

    @Override
    @Transactional(readOnly = true)
    public Marca encontrarMarca(Marca marca) {
        return marcaDao.findById(marca.getIdMarca()).orElse(null);
    }

}
