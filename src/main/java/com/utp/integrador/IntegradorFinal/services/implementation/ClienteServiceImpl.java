package com.utp.integrador.IntegradorFinal.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.integrador.IntegradorFinal.models.dao.ClienteDao;
import com.utp.integrador.IntegradorFinal.models.entity.Cliente;
import com.utp.integrador.IntegradorFinal.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listarClientes(String palabraClave) {
        if(palabraClave !=null){
            return (List<Cliente>) clienteDao.filtrarClientes(palabraClave);
        }
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void eliminar(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente encontrarCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente encontrarUnCliente(Integer palabraClave) {
        if(palabraClave !=null){
            return clienteDao.unCliente(palabraClave);
        }
        return clienteDao.unCliente(1);
    }
    @Override
    public Cliente encontrarClientePorId(Long id) {
        return clienteDao.findById(id).orElseThrow();
    }

}
