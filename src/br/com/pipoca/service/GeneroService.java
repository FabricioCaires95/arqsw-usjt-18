package br.com.pipoca.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pipoca.dao.GeneroDAO;
import br.com.pipoca.model.Genero;

@Service
public class GeneroService {
	
	@Autowired
	private GeneroDAO dao;	

	public Genero buscarGenero(int id) throws IOException {
		return dao.buscarGenero(id);
	}

	public ArrayList<Genero> listarGeneros() throws IOException {
		return (ArrayList<Genero>) dao.listarGeneros();
	}

	public ArrayList<Genero> listaGenFilmes() throws IOException {

		ArrayList<Genero> generos = (ArrayList<Genero>) dao.listarGeneros();

		for (int i = 0; i < generos.size(); i++) {
			generos.get(i).setFilmes(dao.listarFilmes(generos.get(i)));
		}

		return generos;
	}

}