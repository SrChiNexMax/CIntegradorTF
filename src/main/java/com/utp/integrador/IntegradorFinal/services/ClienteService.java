package com.utp.integrador.IntegradorFinal.services;

import java.util.List;

import com.utp.integrador.IntegradorFinal.models.entity.Cliente;

public interface ClienteService {
	
	public List<Cliente> listarClientes();
    
    public void guardar(Cliente cliente);

    public void eliminar(Cliente cliente);

    public Cliente encontrarCliente(Cliente cliente);

}
