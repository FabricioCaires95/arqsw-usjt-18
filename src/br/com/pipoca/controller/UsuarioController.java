package br.com.pipoca.controller;

import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.pipoca.model.Usuario;
import br.com.pipoca.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value="/autenticar", method = RequestMethod.POST)
	public ModelAndView autenticar(Usuario usuario, HttpSession session) {
		ModelAndView andView;
		try {
			usuario = usuarioService.autenticar(usuario);
			if(usuario != null) {
				andView = new ModelAndView("redirect: /pipoca/home");
				session.setAttribute("usuario", usuario);
				return andView;
			}else {
				andView = new ModelAndView("login");
				return andView;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			andView = new ModelAndView("erro");
			andView.addObject("erro",e);
			return andView;
		}
		 
	}
	
}
