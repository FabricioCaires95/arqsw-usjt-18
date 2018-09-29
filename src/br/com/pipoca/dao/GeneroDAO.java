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
		List<Genero> generos = manager.createQuery("select g from genero g").getResultList();
		
		return generos;
	}

	public ArrayList<Filme> listarFilmes(Genero genero) throws IOException{
		ArrayList<Filme> filmes = new ArrayList<>();
		String sql = "select * from filme where id_genero = ?";
			
			try (Connection conn = ConnectionFactory.getConnection();
					PreparedStatement pst = conn.prepareStatement(sql);) {
				pst.setInt(1,genero.getId());
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					Filme filme = new Filme();
					filme.setId(rs.getInt("id"));
					filme.setTitulo(rs.getString("titulo"));
					filme.setDescricao(rs.getString("descricao"));
					filme.setDiretor(rs.getString("diretor"));
					filme.setPosterPath(rs.getString("posterpath"));
					filme.setDataLancamento(rs.getDate("data_lancamento"));
					filme.setPopularidade(rs.getInt("popularidade"));
					filmes.add(filme);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
			return filmes;
	}
}