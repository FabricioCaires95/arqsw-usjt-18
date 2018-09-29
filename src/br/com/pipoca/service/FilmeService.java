package br.com.pipoca.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pipoca.dao.FilmeDAO;
import br.com.pipoca.model.Filme;

@Service
public class FilmeService {
	
	@Autowired
	private FilmeDAO dao;
	
	
	public Filme buscarFilme(int id) throws IOException{
		return dao.buscarFilme(id);
	}
	
	public void inserirFilme(Filme filme) throws IOException {
		dao.inserirFilme(filme);
	}
	
	public ArrayList<Filme> listarFilmes(String chave) throws IOException{
		return dao.listarFilmes(chave);
	}

	public List<Filme> listarFilmes() throws IOException{
		return dao.listarFilmes();
	}

	public void updateFilme(Filme filme) throws IOException {
		dao.updateFilme(filme);
	}

	public void deleteFilme(Filme filme) throws IOException {
		dao.deletaFilme(filme);;
		
	}
	
	public ArrayList<Filme> listarPopulares(Integer inicio,Integer fim) throws IOException{
		return dao.listarPopulares(inicio, fim);
	}
	
	public ArrayList<Filme> porData(String chave,Integer periodo) throws IOException{
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

}