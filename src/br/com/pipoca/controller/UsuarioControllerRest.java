package br.com.pipoca.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pipoca.model.Usuario;
import br.com.pipoca.service.UsuarioService;

public class UsuarioControllerRest {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.POST,value="rest/usuario")
	public ResponseEntity <Usuario> logar(@RequestBody Usuario usuario){
		System.out.println(usuario);
		
		try {
			usuario = usuarioService.autenticar(usuario);
			if (usuario == null ) {
				return new ResponseEntity<Usuario>(usuario,HttpStatus.NOT_FOUND);
			}
			else {
			 return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
			}
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<Usuario>(usuario,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
