package br.com.pipoca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import br.com.pipoca.dao.UsuarioDAO;
import br.com.pipoca.model.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO dao;
	
	public UsuarioService() {
		this.dao = new UsuarioDAO();
	}
	
	public Usuario autenticar(Usuario usuario) throws IOException {
		usuario =  dao.autenticar(usuario);
		return usuario;
	}


	
}
