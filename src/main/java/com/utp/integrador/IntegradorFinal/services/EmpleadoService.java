package com.utp.integrador.IntegradorFinal.services;

import java.util.List;

import com.utp.integrador.IntegradorFinal.models.entity.Empleado;

public interface EmpleadoService {
    
public List<Empleado> listarEmpleados();
    
    public void guardar(Empleado empleado);
    
    public Empleado encontrarEmpleado(Empleado empleado);
    
    public Empleado registrarNuevoEmpleado(Empleado empleado) throws Exception;

}
