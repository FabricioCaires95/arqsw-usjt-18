package br.com.pipoca.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import br.com.pipoca.model.Filme;
import br.com.pipoca.model.Genero;
import br.com.pipoca.service.FilmeService;
import br.com.pipoca.service.GeneroService;

@Controller
//@RequestMapping("filme")
public class FilmeController {
	
	
	private ModelAndView andView;
	
	private FilmeService filmeService;
	
	private GeneroService generoService;
	
	
	public FilmeController() {
		this.filmeService = new FilmeService();
		this.generoService = new GeneroService();
	}
	
	@RequestMapping("/novo")
	public ModelAndView novoFilme() throws IOException {
		ModelAndView andView = new ModelAndView("novo");
		ArrayList<Genero> list = generoService.listarGeneros();
		andView.addObject(list);
		return andView;
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/")
	public String iniciar() {
		return "login";
	}
	
	@RequestMapping(value="/inserir", method = RequestMethod.POST)
	public ModelAndView inserirFilme(@ModelAttribute("filme") Filme filmeRequest) {
		System.out.println("Entrou");
		
		try {
			Genero genero = new Genero();
			genero.setId(12);
			genero.setNome("adasd");
			filmeRequest.setGenero(genero);
			filmeService.inserirFilme(filmeRequest);
			andView = new ModelAndView("inserido");
			andView.addObject("filme",filmeRequest);
			return andView;
		}catch(IOException e) {
			e.printStackTrace();
			ModelAndView andView = new ModelAndView("inserido");
			andView.addObject("erro",e);
			return andView;
		}
		 
	}
	
	@RequestMapping("/novo_filme")
	public String novo(Model model) {
		try {
			generoService = new GeneroService();
			ArrayList<Genero> generos = generoService.listarGeneros();
			model.addAttribute("generos", generos);
			return "CriarFilme";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}

	@PostMapping("/criar_filme")
	public String criarFilme(@Valid Filme filme, BindingResult result, Model model) {
		try {
			
			if(result.hasErrors()) {
				generoService = new GeneroService();
				ArrayList<Genero> generos = generoService.listarGeneros();
				model.addAttribute("generos", generos);
				return "CriarFilme";
			}
			
			Genero genero = new Genero();
			genero.setId(filme.getGenero().getId());
			genero.setNome(generoService.buscarGenero(genero.getId()).getNome());
			filme.setGenero(genero);

			filme = filmeService.inserirFilme(filme);

			return "redirect: /pipoca/visualizar/" + filme.getId();
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "erro";
		}
	}
	
	@PostMapping("/delete")
	public String  deleteFilme(Integer id) throws IOException {
		System.out.println(id);
		filmeService.deleteFilme(id);
		return "redirect: /pipoca/filmes";
	}
	
	@PostMapping("/update")
	public String updateFilme(Filme filme) throws IOException {
		andView = new ModelAndView("VisualizarFilme");
		filmeService.updateFilme(filme);
		return "redirect: /pipoca/visualizar/"+filme.getId();
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editarFilme(@PathVariable Integer id) throws IOException {
		andView = new ModelAndView("EditarFilme");
		Filme filme = filmeService.buscarFilme(id);
		ArrayList<Genero> generos = generoService.listarGeneros();
		andView.addObject("filme", filme);
		andView.addObject("generos", generos);
		return andView;
	}
	
	@GetMapping("/visualizar/{id}")
	public ModelAndView visualizarFilme(@PathVariable Integer id) throws IOException {
		andView = new ModelAndView("VisualizarFilme");
		Filme filme = filmeService.buscarFilme(id);
		andView.addObject("filme", filme);
		return andView;
	}

	@RequestMapping("/filmes")
	public ModelAndView reiniciarLista(HttpSession session) throws IOException {
		session.setAttribute("lista", null);
		ArrayList<Filme> lista;
		lista = filmeService.listarFilmes();
		andView = new ModelAndView("ListarFilmes");
		andView.addObject("lista",lista);
		return andView;
	}

	@RequestMapping("/listar_filmes")
	public String listarFilmes(HttpSession session, Model model, String chave) {
		try {
			//HttpSession session = ((HttpServletRequest) model).getSession();

			ArrayList<Filme> lista;
			if (chave != null && chave.length() > 0) {
				lista = filmeService.listarFilmes(chave);
			} else {
				lista = filmeService.listarFilmes();
			}
			session.setAttribute("lista", lista);
			return "ListarFilmes";
		} catch (IOException e) {
			e.printStackTrace();
			model.addAttribute("erro", e);
			return "Erro";
		}
	}
	
	@GetMapping("/catalogo/genero")
	public ModelAndView porGeneros(Model model) throws IOException {
		ModelAndView andView = new ModelAndView("CatalogoGenero");
		ArrayList <Genero> porGeneros = generoService.listaGenFilmes();
		andView.addObject("porGeneros",porGeneros);
		return andView;
	}
	
	@GetMapping("/catalogo/lancamento")
	public ModelAndView porDtLancamento(Model model) throws IOException {
		ModelAndView andView = new ModelAndView("CatalogoDataLancamento");
		ArrayList<Filme> filmesAno = filmeService.porData("ano",1);
		
		ArrayList<Filme> filmesPenultimo = filmeService.porData("ano",2);
		ArrayList<Filme> filmesMes = filmeService.porData("mes",1);
		andView.addObject("filmesAno",filmesAno);
		andView.addObject("filmesMes",filmesMes);
		andView.addObject("filmesPenultimo",filmesPenultimo);
		return andView;
	}
	
	@GetMapping("/catalogo/popularidade")
	public ModelAndView porPopularidade(Model model) throws IOException {
		ModelAndView andView = new ModelAndView("CatalogoPopularidade");
		ArrayList<Filme> filmes1 = filmeService.listarPopulares(0,30);
		ArrayList<Filme> filmes2 = filmeService.listarPopulares(31,50);
		ArrayList<Filme> filmes3 = filmeService.listarPopulares(51,60);
		ArrayList<Filme> filmes4 = filmeService.listarPopulares(61,80);
		ArrayList<Filme> filmes5 = filmeService.listarPopulares(81,100);
		andView.addObject("filmes1",filmes1);
		andView.addObject("filmes2",filmes2);
		andView.addObject("filmes3",filmes3);
		andView.addObject("filmes4",filmes4);
		andView.addObject("filmes5",filmes5);
		return andView;
	}
	
}