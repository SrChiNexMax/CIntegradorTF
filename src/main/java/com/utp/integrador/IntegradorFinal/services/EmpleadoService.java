package com.utp.integrador.IntegradorFinal.services;

import java.util.List;

import com.utp.integrador.IntegradorFinal.models.entity.Empleado;

public interface EmpleadoService {
    
    public List<Empleado> listarUsuarios(String estado);
    
    public List<Empleado> listarEmpleados();
    
    public void guardar(Empleado empleado);
    
    public Empleado encontrarEmpleado(Empleado empleado);
    
    public Empleado registrarNuevoEmpleado(Empleado empleado) throws Exception;

	public Empleado registrarNuevoUsuario(Empleado empleado);

    public void modificarUsuario(Empleado empleado);

    public void modificarEmpleado(Empleado empleado);

}
