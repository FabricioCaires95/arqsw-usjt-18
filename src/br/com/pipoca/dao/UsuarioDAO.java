package br.com.pipoca.dao;

import java.sql.PreparedStatement;

import org.springframework.stereotype.Component;

import br.com.pipoca.model.Usuario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UsuarioDAO {

	
public Usuario autenticar(Usuario usuario) throws IOException {
		
		String sql = "select * from usuario where username = ? and password = ?";
		try(Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);){	
				pst.setString (1, usuario.getUserName());
				pst.setString (2, usuario.getPassword());
			
				try(ResultSet rs = pst.executeQuery();){
				
					if(rs.next()) {
						usuario.setId(rs.getInt("id"));
						return usuario;
					}else {
						return null;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
			}
	}
}
