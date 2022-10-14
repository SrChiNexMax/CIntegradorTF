package com.utp.integrador.IntegradorFinal.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utp.integrador.IntegradorFinal.models.dao.UsuarioDao;
import com.utp.integrador.IntegradorFinal.models.entity.Usuario;
import com.utp.integrador.IntegradorFinal.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listarUsuarios() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Usuario usuario) {
		usuarioDao.save(usuario);
		
	}

	@Override
	@Transactional
	public void eliminar(Usuario usuario) {
		usuarioDao.delete(usuario);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario encontrarUsuario(Usuario usuario) {
			return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
	}
	
	
	
}
