package com.utp.integrador.IntegradorFinal.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.utp.integrador.IntegradorFinal.models.dao.EmpleadoDao;
import com.utp.integrador.IntegradorFinal.models.entity.Empleado;

public class EmpleadoDetailsService implements UserDetailsService {
	
	@Autowired
	private EmpleadoDao empleadoDao;

	@Override
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
		Empleado empleado = empleadoDao.findByDni(dni);
		
		if (empleado == null) {
            throw new UsernameNotFoundException("No se encontro empleado con DNI: " + dni);
        }
		
		boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<String> rol = new ArrayList<>();
        
        if (!empleado.getEstado().equalsIgnoreCase("laborando")) {
        	enabled = false;
        } 
        
        if (empleado.getAcceso().equalsIgnoreCase("usuario")) {
        	rol.add("ROLE_USUARIO");
        } else if (empleado.getAcceso().equalsIgnoreCase("administrador")) {
        	rol.add("ROLE_ADMIN");
        }
				
		return new org.springframework.security.core.userdetails.User(
				String.valueOf(empleado.getDni()),
				empleado.getClave(), 
				enabled, 
				accountNonExpired, 
				credentialsNonExpired,
				accountNonLocked, 
				getAuthorities(rol));
		
	}
	
	private static List<GrantedAuthority> getAuthorities (List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        
        return authorities;
    }

}
