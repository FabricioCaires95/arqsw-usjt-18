package br.com.pipoca.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import br.com.pipoca.dao.FilmeDAO;
import br.com.pipoca.model.Filme;
import br.com.pipoca.model.FilmeTMDb;
import br.com.pipoca.model.ResultadoTMDb;

@Service
public class FilmeService {
	
	
	private static final String KEY = "83cd8cc234ea9b5b4d36b73c38f8fb22";
	
	@Autowired
	private FilmeDAO dao;
	
	@Transactional
	public Filme buscarFilme(int id) throws IOException{
		return dao.buscarFilme(id);
	}
	
	@Transactional
	public Filme inserirFilme(Filme filme) throws IOException {
		dao.inserirFilme(filme);
		return filme;
	}
	
	public List<Filme> listarFilmes(String chave) throws IOException{
		return dao.listarFilmes(chave);
	}

	public List<Filme> listarFilmes() throws IOException{
		return dao.listarFilmes();
	}
	
	@Transactional
	public Filme updateFilme(Filme filme) throws IOException {
		return dao.updateFilme(filme);
	}
	
	@Transactional
	public void deleteFilme(Filme filme) throws IOException {
		dao.deletaFilme(filme);;
		
	}
	
	public List<Filme> listarPopulares(double d,double e) throws IOException{
		return dao.listarPopulares(d, e);
	}
	
	public List<Filme> porData(String chave,Integer periodo) throws IOException{
		Date data = new Date();
		Calendar calendar = Calendar.getInstance();
		if(chave.equals("ano")) {
			calendar.add(Calendar.YEAR,(periodo)*-1);
			calendar.set(Calendar.MONTH,0);
			calendar.set(Calendar.DAY_OF_MONTH,1);
		}
		else {
			calendar.add(Calendar.MONTH,-1*(periodo));
			calendar.set(Calendar.DAY_OF_MONTH,1);
		}
		data = calendar.getTime();
		System.out.println(data);
		return dao.porData(data); 
	}

	public void excluirFilme(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	public void gravarImagem(ServletContext servletContext, Filme filme, MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
			String path = servletContext.getRealPath(servletContext.getContextPath());
			path = path.substring(0, path.lastIndexOf('\\'));
			String nomeArquivo = "img"+filme.getId()+".jpg";
			filme.setPosterPath(nomeArquivo);
			updateFilme(filme);
			File destination = new File(path + File.separatorChar + "img" + File.separatorChar + nomeArquivo);
			
			if(destination.exists()) {
				destination.delete();
			}
			ImageIO.write(src, "jpg", destination);
		}
	}
	


	public ArrayList<FilmeTMDb> buscaFilmesTMDb() {
		RestTemplate restTemplate = new RestTemplate();
		ResultadoTMDb resultado = restTemplate.getForObject(montaURL("now_playing"), ResultadoTMDb.class);
		return resultado.getResults();
	}
	
	public FilmeTMDb buscaFilmeTMDb(String id) {
		RestTemplate restTemplate = new RestTemplate();
		FilmeTMDb resultado = restTemplate.getForObject(montaURL(id), FilmeTMDb.class);
		return resultado;
	}

	private String montaURL(String param) {
		final String SEPARADOR = ",";
		String url = "https://api.themoviedb.org/3/movie/"+param+"?api_key="+KEY+"&language=pt-BR";
		return url;
	}

}