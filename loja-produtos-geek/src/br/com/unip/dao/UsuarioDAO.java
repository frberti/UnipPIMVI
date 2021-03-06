package br.com.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unip.modelo.Categoria;
import br.com.unip.modelo.Produto;
import br.com.unip.modelo.Usuario;


public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(Usuario usuario) throws SQLException {
		try (PreparedStatement pstm = connection.prepareStatement(
				"INSERT INTO USUARIO(login, senha, idNivelUsuario)VALUES(?,?,?)",
				Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, usuario.getLogin());
			pstm.setString(2, usuario.getSenha());
			pstm.setInt(3, usuario.getIdNivelUsuario());
						
			pstm.execute();
			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					usuario.setIdUsuario(rst.getInt(1));
				}
			}
		}
	}

	public List<Usuario> listar() throws SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try (PreparedStatement pstm = connection.prepareStatement("SELECT * FROM USUARIO")) {
			pstm.execute();
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					Usuario categoria = new Usuario(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4));
					usuarios.add(categoria);
				}
			}
		}
		return usuarios;
	}

	public void atualizar(Usuario usuario) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("UPDATE USUARIO U SET U.login = ?, "
				+ "U.senha = ?, U.idNivelUsuario = ?")){
			pstm.setString(1, usuario.getLogin());
			pstm.setString(2, usuario.getSenha());
			pstm.setInt(3, usuario.getIdNivelUsuario());
			pstm.execute();
		}

	}

	public void remover(Usuario usuario) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("DELETE FROM USUARIO WHERE ID = ?")) {
			pstm.setInt(1, usuario.getIdUsuario());
			pstm.execute();
		}

	}

}
