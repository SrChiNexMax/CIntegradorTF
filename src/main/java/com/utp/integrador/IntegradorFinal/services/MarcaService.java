package com.utp.integrador.IntegradorFinal.services;

import java.util.List;

import com.utp.integrador.IntegradorFinal.models.entity.Marca;

public interface MarcaService {
    
    public List<Marca> listarMarcas();
    
    public void guardar(Marca marca);
    
    public Marca encontrarMarca(Marca marca);
}
