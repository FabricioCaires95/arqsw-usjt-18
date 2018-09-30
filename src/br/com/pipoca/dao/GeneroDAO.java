package br.com.pipoca.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import br.com.pipoca.model.Filme;
import br.com.pipoca.model.Genero;

@Entity
public class GeneroDAO {
	
	@PersistenceContext
	EntityManager manager;

	public Genero buscarGenero(int id) throws IOException {
		return manager.find(Genero.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Genero> listarGeneros() throws IOException {
		List<Genero> generos = manager.createQuery("select g from Genero g").getResultList();
		
		return generos;
	}

	public List<Filme> listarFilmes(Genero genero) throws IOException{
		
		String jpql = "select f from Filme f where id_genero=:id";
		Query query = manager.createQuery(jpql);
		query.setParameter("id", genero.getId());
		List<Filme> filmes = query.getResultList();
		return filmes;
	}
}