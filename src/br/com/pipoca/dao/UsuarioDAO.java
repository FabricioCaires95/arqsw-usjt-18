package br.com.pipoca.dao;

import java.sql.PreparedStatement;

import org.springframework.stereotype.Component;

import br.com.pipoca.model.Usuario;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
public class UsuarioDAO {

	@PersistenceContext
	EntityManager manager;	
	
	public Usuario autenticar(Usuario usuario) throws IOException {	
		
		String jpql = "select u from Usuario u where u.email = :email and u.senha=: senha";
		System.out.println(usuario.getEmail());
		try{
			System.out.println("entrou no try");
			Query query = manager.createQuery(jpql)
					
					.setParameter("email",usuario.getEmail())
					.setParameter("senha",usuario.getEmail());
			return (Usuario) query.getSingleResult();
			
			}catch (NoResultException nre){
				System.out.println("caiu no catch");
				System.out.println(nre);
			return null;
			}
	}

}