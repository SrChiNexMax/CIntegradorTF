package com.utp.integrador.IntegradorFinal.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.integrador.IntegradorFinal.models.dao.EmpleadoDao;
import com.utp.integrador.IntegradorFinal.models.entity.Empleado;
import com.utp.integrador.IntegradorFinal.services.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    
    @Autowired
    private EmpleadoDao empleadoDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> listarEmpleados() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Empleado empleado) {
        empleadoDao.save(empleado);
        
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado encontrarEmpleado(Empleado empleado) {
            return empleadoDao.findById(empleado.getIdEmpleado()).orElse(null);
    }

	@Override
	@Transactional
	public Empleado registrarNuevoEmpleado(Empleado empleado) throws Exception {
		if(existeEmpleado(empleado.getDni())) {
			throw new Exception("Ya existe una cuenta registrada con el DNI: "
					+ empleado.getDni());
		}
		
		Empleado emp = empleado;
		emp.setEstado("Laborando");
		emp.setClave(passwordEncoder.encode(empleado.getClave()));
		
		return empleadoDao.save(emp);
					
		
	}
	
	private boolean existeEmpleado(String dni) {
		return empleadoDao.findByDni(dni) != null;
	}

	

}
