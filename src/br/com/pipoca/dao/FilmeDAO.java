package br.com.pipoca.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.pipoca.model.Filme;
import br.com.pipoca.model.Genero;


@Repository
public class FilmeDAO {
	
	@PersistenceContext
	EntityManager manager;
	
	public void inserirFilme(Filme filme) throws IOException {
		manager.getTransaction().begin();
		manager.persist(filme);
		manager.getTransaction().commit();
	}

	public Filme buscarFilme(int id) throws IOException{
		return manager.find(Filme.class, id);
	}

	public ArrayList<Filme> listarFilmes(String chave) throws IOException {
		ArrayList<Filme> lista = new ArrayList<>();
		String sql = "select f.id, f.titulo, f.descricao, f.diretor, f.posterpath, "
				+ "f. popularidade, f.data_lancamento, f.id_genero, g.nome "
				+ "from filme f, genero g "
				+ "where f.id_genero = g.id and upper(f.titulo) like ?";
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			
			pst.setString(1, "%" + chave.toUpperCase() + "%");
		
			try(ResultSet rs = pst.executeQuery();){
			
				Filme filme;
				Genero genero;
				while(rs.next()) {
					filme = new Filme();
					filme.setId(rs.getInt("f.id"));
					filme.setTitulo(rs.getString("f.titulo"));
					filme.setDescricao(rs.getString("f.descricao"));
					filme.setDiretor(rs.getString("f.diretor"));
					filme.setPosterPath(rs.getString("f.posterpath"));
					filme.setDataLancamento(rs.getDate("f.data_lancamento"));
					genero = new Genero();
					genero.setId(rs.getInt("f.id_genero"));
					genero.setNome(rs.getString("g.nome"));
					filme.setGenero(genero);
					lista.add(filme);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}
				
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Filme> listarFilmes() throws IOException {
		return manager.createQuery("select f from Filme f").getResultList();
	}

	public void updateFilme(Filme filme) throws IOException {
		manager.merge(filme);	
		
	}
	
	public void deletaFilme(Filme filme) throws IOException {
		manager.remove(filme);
	}
	
	public ArrayList<Filme> listarPopulares(Integer inicio, Integer fim) throws IOException {
		ArrayList<Filme> lista = new ArrayList<>();
		String sql = "select f.id, f.titulo, f.descricao, f.diretor, f.posterpath, f.popularidade, f.data_lancamento, f.id_genero, g.id, g.nome from filme f  join genero g on id_genero = g.id where f.popularidade between ? and ? ";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setInt(1, inicio);
			pst.setInt(2, fim);
			ResultSet rs = pst.executeQuery();
			Filme filme;
			Genero genero;
			while(rs.next()) {
				filme = new Filme();
				filme.setId(rs.getInt("f.id"));
				filme.setTitulo(rs.getString("f.titulo"));
				filme.setDescricao(rs.getString("f.descricao"));
				filme.setDiretor(rs.getString("f.diretor"));
				filme.setPosterPath(rs.getString("f.posterpath"));
				filme.setDataLancamento(rs.getDate("f.data_lancamento"));
				genero = new Genero();
				genero.setId(rs.getInt("f.id_genero"));
				genero.setNome(rs.getString("g.nome"));
				filme.setGenero(genero);
				lista.add(filme);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}				
		return lista;
	}
	
	public ArrayList<Filme> porData(Date data) throws IOException {
		Date dataAtual = new Date();

		ArrayList<Filme> lista = new ArrayList<>();
		String sql = "select f.id, f.titulo, f.descricao, f.diretor, f.posterpath, f.popularidade, f.data_lancamento, f.id_genero, g.id, g.nome from filme f  join genero g on id_genero = g.id where f.data_lancamento between ? and ? ";
		
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setDate(1,new java.sql.Date(data.getTime()));
			pst.setDate(2, new java.sql.Date(dataAtual.getTime()));
			ResultSet rs = pst.executeQuery();
			Filme filme;
			Genero genero;
			while(rs.next()) {
				filme = new Filme();
				filme.setId(rs.getInt("f.id"));
				filme.setTitulo(rs.getString("f.titulo"));
				filme.setDescricao(rs.getString("f.descricao"));
				filme.setDiretor(rs.getString("f.diretor"));
				filme.setPosterPath(rs.getString("f.posterpath"));
				filme.setDataLancamento(rs.getDate("f.data_lancamento"));
				genero = new Genero();
				genero.setId(rs.getInt("f.id_genero"));
				genero.setNome(rs.getString("g.nome"));
				filme.setGenero(genero);
				lista.add(filme);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IOException(e);
		}				
		return lista;
	}
}