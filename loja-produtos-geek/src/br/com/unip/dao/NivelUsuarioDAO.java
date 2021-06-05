package br.com.unip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unip.modelo.Categoria;
import br.com.unip.modelo.NivelUsuario;
import br.com.unip.modelo.Produto;


public class NivelUsuarioDAO {

	private Connection connection;

	public NivelUsuarioDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastrar(NivelUsuario nivelUsuario) throws SQLException {
		try (PreparedStatement pstm = connection.prepareStatement(
				"INSERT INTO NivelUsuario(nivel)VALUES(?)",
				Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, nivelUsuario.getNivel());
						
			pstm.execute();
			try (ResultSet rst = pstm.getGeneratedKeys()) {
				while (rst.next()) {
					nivelUsuario.setIdNivel(rst.getInt(1));
				}
			}
		}
	}

	public List<NivelUsuario> listar() throws SQLException {
		List<NivelUsuario> nivelUsuarios = new ArrayList<NivelUsuario>();
		try (PreparedStatement pstm = connection.prepareStatement("SELECT * FROM NivelUsuario")) {
			pstm.execute();
			try (ResultSet rst = pstm.getResultSet()) {
				while (rst.next()) {
					NivelUsuario nivelUsuario = new NivelUsuario(rst.getInt(1), rst.getString(2));
					nivelUsuarios.add(nivelUsuario);
				}
			}
		}
		return nivelUsuarios;
	}

	public void atualizar(NivelUsuario nivelUsuario) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("UPDATE NivelUsuario NU SET NU.nivel = ?")){
			pstm.setString(1, nivelUsuario.getNivel());
			pstm.execute();
		}

	}

	public void remover(NivelUsuario nivelUsuario) throws SQLException {
		
		try(PreparedStatement pstm = connection.prepareStatement("DELETE FROM NivelUsuario WHERE ID = ?")) {
			pstm.setInt(1, nivelUsuario.getIdNivel());
			pstm.execute();
		}

	}

}
